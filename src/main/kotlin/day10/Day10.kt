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

fun main() {
    val joltsOfAdapters = ParseUtil.inputLines(10).map { it.toInt() }
    val differences = differencesWhenConnected(joltsOfAdapters)
    println("Part 1 = ${differences[1]!! * differences[3]!!}")
}