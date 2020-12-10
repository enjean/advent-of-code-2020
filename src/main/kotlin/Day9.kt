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

fun main() {
    val input = ParseUtil.inputLines(9).map { it.toLong() }

    println("Part 1 = ${findInvalid(input, 25)}")
}