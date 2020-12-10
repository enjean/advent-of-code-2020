import util.ParseUtil

fun findInvalid(input: List<Long>, preambleSize: Int): Long =
    (preambleSize until input.size).find {
        !isNumberAtValid(input, it, preambleSize)
    }?.let { input[it] } ?: throw IllegalArgumentException("No value found")

private fun isNumberAtValid(input: List<Long>, index: Int, preambleSize: Int): Boolean {
    val value = input[index]
    for (i in index - preambleSize until index - 1) {
        for (j in i + 1 until index) {
            val iVal = input[i]
            val jVal = input[j]
            if (iVal != jVal && iVal + jVal == value) {
                return true
            }
        }
    }
    return false
}

fun findRangeAddingTo(input: List<Long>, value: Long): Pair<Long, Long> {
    val maxIndexToConsider = input.indices.find { input[it] >= value } ?: input.size-1
    for (i in 0 until maxIndexToConsider) {
        for (setSize in 2 until maxIndexToConsider-i) {
            val nums = input.subList(i, i + setSize)
            if (nums.sum() == value) {
                return Pair(nums.minOrNull()!!, nums.maxOrNull()!!)
            }
        }
    }
    throw IllegalArgumentException("No Match found")
}

fun main() {
    val input = ParseUtil.inputLines(9).map { it.toLong() }

    val invalidValue = findInvalid(input, 25)
    println("Part 1 = $invalidValue")

    val part2 = findRangeAddingTo(input, invalidValue)
    println("Part 2 = ${part2.first + part2.second}")
}