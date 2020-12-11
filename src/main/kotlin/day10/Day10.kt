package day10

import util.ParseUtil

fun differencesWhenConnected(joltsOfAdapters: List<Int>): Map<Int, Int> {
    val sortedJoltsOfAdapters = joltsOfAdapters.sorted()
    val differences = sortedJoltsOfAdapters.mapIndexed { index, jolts ->
        if (index == 0) jolts else jolts - sortedJoltsOfAdapters[index - 1]
    }.plus(3)
    return (1..3).map { differenceValue ->
        differenceValue to differences.count { it == differenceValue }
    }.toMap()
}

fun possibleCombinations(joltsOfAdapters: List<Int>) : Long {
    val max = joltsOfAdapters.maxOrNull()!!
    val joltsSorted = (joltsOfAdapters + 0 + (max + 3)).sorted()
    val joltsSet = joltsSorted.toSet()
    val children = joltsSorted.fold(emptyMap<Int, Set<Int>>()) { mapSoFar, joltValue ->
        mapSoFar + (joltValue to childrenOf(joltValue, joltsSet))
    }
    val combosThroughAdaptor = joltsSorted.foldRight(emptyMap<Int, Long>()) { joltValue, combosThroughAdaptorSoFar ->
        children[joltValue]?.let { childrenForAdaptor ->
            val combosForThisAdaptor = if (childrenForAdaptor.isEmpty()) {
                1L
            } else {
                childrenForAdaptor.fold(0L) { sum, child ->
                    sum + combosThroughAdaptorSoFar[child]!!
                }
            }
//            println("F[$joltValue] = $combosForThisAdaptor")
            combosThroughAdaptorSoFar + (joltValue to combosForThisAdaptor)
        } ?: throw IllegalStateException("No children value found")
    }
    return combosThroughAdaptor[0]!!
}

private fun childrenOf(joltValue: Int, joltsOfAdapters: Set<Int>) : Set<Int> =
    (1..3).fold(emptySet()) { childrenSoFar, diff ->
        val possibleChild = joltValue + diff
        if (joltsOfAdapters.contains(possibleChild)) childrenSoFar + possibleChild else childrenSoFar
    }



fun main() {
    val joltsOfAdapters = ParseUtil.inputLines(10).map { it.toInt() }
    val differences = differencesWhenConnected(joltsOfAdapters)
    println("Part 1 = ${differences[1]!! * differences[3]!!}")
    println("Part 2 = ${possibleCombinations(joltsOfAdapters)}")
}