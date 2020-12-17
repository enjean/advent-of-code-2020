package day13

import util.ParseUtil
import java.lang.RuntimeException

fun parseBusIds(input: String) : Set<Int> =
    input.split(",")
        .filterNot { it == "x" }
        .map { it.toInt() }
        .toSet()

fun busToCatch(time: Int, busIds: Set<Int>) : Pair<Int, Int> =
    busIds.map { busId ->
        busId to (busId * (time/busId + 1)) - time
    }.minByOrNull {
        it.second
    } ?: throw RuntimeException("Unable to find min")

fun main() {
    val input = ParseUtil.inputLines(13)
    val time = input[0].toInt()
    val busIds = parseBusIds(input[1])

    val earliestBus = busToCatch(time, busIds)
    println("Part 1 = ${earliestBus.first * earliestBus.second}")
}