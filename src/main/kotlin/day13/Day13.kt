package day13

import util.ParseUtil
import java.lang.RuntimeException

fun parseBusIds(input: String): List<String> =
    input.split(",")

fun busToCatch(time: Int, busIds: List<String>): Pair<Int, Int> =
    busIds.filterNot { it == "x" }
        .map { it.toInt() }
        .map { busTime ->
            busTime to (busTime * (time / busTime + 1)) - time
        }.minByOrNull {
            it.second
        } ?: throw RuntimeException("Unable to find min")

fun timeMatchingOffsets(busIds: List<String>): Long {
    val idsWithOffset = busIds.mapIndexed { index, id -> id to index }
        .filterNot { it.first == "x" }
        .map { it.first.toLong() to it.second }
//    var n = idsWithOffset.first().first.toLong()
//    while(n < 1000) {
//        val matches = idsWithOffset.filter {
//            val valueToTry = n + it.second
//            (valueToTry % it.first) == 0.toLong()
//        }.map { it.first }
//        if (matches.size > 1) {
//            println("$n matches $matches")
//        }
//        n += idsWithOffset.first().first
//    }

    val initial = idsWithOffset.first().first
    return idsWithOffset.subList(1, idsWithOffset.size).fold(StepInfo(initial, initial)) { acc, i ->
        firstMatch(acc.value, i.first, i.second, acc.step)
    }.value
}

data class StepInfo(
    val value: Long,
    val step: Long
)

fun firstMatch(base: Long, value: Long, offset: Int, stepSize: Long) : StepInfo {
    var n = base
    while((n + offset) % value != 0.toLong()) {
        n += stepSize
    }
    println("Found match $base $value $offset at $n")
    val firstIntersection = n
    n += stepSize
    while((n + offset) % value != 0.toLong()) {
        n += stepSize
    }
    println("Found next match $base $value $offset at $n")
    val secondMatch = n
    return StepInfo(firstIntersection, secondMatch - firstIntersection)
}

fun main() {
    val input = ParseUtil.inputLines(13)
    val time = input[0].toInt()
    val busIds = parseBusIds(input[1])

    val earliestBus = busToCatch(time, busIds)
    println("Part 1 = ${earliestBus.first * earliestBus.second}")

    println("Part 2 = ${timeMatchingOffsets(busIds)}")
}