package day16

import util.ParseUtil

data class Input(
    val fieldValidRanges: Map<String, List<IntRange>>,
    val yourTicket: List<Int>,
    val nearbyTickets: List<List<Int>>
)

fun parseInput(lines: List<String>): Input {
    val yourTicketHeader = lines.indexOf("your ticket:")
    val fieldValidRanges = lines.subList(0, yourTicketHeader - 1).map { line ->
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

fun invalidValues(input: Input): List<Int> =
    input.nearbyTickets.flatMap { invalidFields(it, input) }

private fun invalidFields(ticket: List<Int>, input: Input): List<Int> =
    ticket.filterNot { ticketValue ->
        input.fieldValidRanges.values.any { ranges ->
            ranges.any { range -> range.contains(ticketValue) }
        }
    }

fun determineFields(input: Input): List<String> {
    val validNearbyTickets = input.nearbyTickets.filter { invalidFields(it, input).isEmpty() }
    val matchesPerField = (input.yourTicket.indices).map { index ->
        val valuesAtIndex = validNearbyTickets.map { nearbyTicket -> nearbyTicket[index] }
        index to input.fieldValidRanges.entries.filter { entry ->
            valuesAtIndex.all { value ->
                entry.value.any { range -> range.contains(value) }
            }
        }.map { it.key }.toSet()
    }.toMap()
    val matches = settleMatches(emptyMap(), matchesPerField)
    return matches.entries.toList().sortedBy { it.key }.map { it.value }
}

private tailrec fun settleMatches(settled: Map<Int, String>, toBeSettled: Map<Int, Set<String>>): Map<Int, String> =
    if (toBeSettled.isEmpty()) {
        settled
    } else {
        val canBeSettled = checkNotNull(toBeSettled.entries.find { it.value.size == 1 })
        val foundFieldName = canBeSettled.value.first()
        val matchedIndex = canBeSettled.key
        val remaining = toBeSettled.filterNot { it.key == matchedIndex }
            .mapValues { entry ->
                entry.value - foundFieldName
            }
        settleMatches(settled + (matchedIndex to foundFieldName), remaining)
    }


fun main() {
    val input = parseInput(ParseUtil.inputLines(16))

    println("Part 1 = ${invalidValues(input).sum()}")

    val fields = determineFields(input)
    val myTicketFields = fields.mapIndexed { index, field ->
        field to input.yourTicket[index]
    }
    val departureFields = myTicketFields.filter { it.first.startsWith("departure") }
    println("Part 2 = ${departureFields.map { it.second.toLong() }.reduce { acc, i -> acc * i }}")
}