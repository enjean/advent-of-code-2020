package day16

import util.ParseUtil

data class Input(
    val fieldValidRanges: Map<String, List<IntRange>>,
    val yourTicket: List<Int>,
    val nearbyTickets: List<List<Int>>
)

fun parseInput(lines: List<String>): Input {
    val yourTicketHeader = lines.indexOf("your ticket:")
    val fieldValidRanges = lines.subList(0, yourTicketHeader-1).map {  line ->
        val parts = line.split(": ")
        val fieldName = parts[0]
        val ranges = parts[1].split(" or ").map {
            val lowHigh = it.split("-")
            lowHigh[0].toInt()..lowHigh[1].toInt()
        }
        Pair(fieldName, ranges)
    }.toMap()
    val yourTicket = lines[yourTicketHeader + 1].split(",").map { it.toInt() }
    val nearbyTickets = lines.subList(yourTicketHeader + 4, lines.size).map { line ->
        line.split(",").map { it.toInt() }
    }
    return Input(fieldValidRanges, yourTicket, nearbyTickets)
}

fun invalidValues(input: Input) : List<Int> =
    input.nearbyTickets.flatMap { nearbyTicket ->
        nearbyTicket.filterNot { ticketValue ->
            input.fieldValidRanges.values.any { ranges ->
                ranges.any { range -> range.contains(ticketValue) }
            }
        }
    }

fun main() {
    val input = parseInput(ParseUtil.inputLines(16))

    println("Part 1 = ${invalidValues(input).sum()}")
}