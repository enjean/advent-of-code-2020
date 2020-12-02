package day2

import java.io.File

fun parse(line: String): Pair<PasswordPolicy, String> {
    val parts = line.split(": ")
    val policyString = parts[0]
    val policyParts = policyString.split(" ")
    val minMaxString = policyParts[0].split("-")
    return PasswordPolicy(policyParts[1].single(), minMaxString[0].toInt(), minMaxString[1].toInt()) to parts[1]
}

fun main() {
    val lines = File("src/main/resources/day2/input.txt").readLines()
        .map { parse(it) }

    val part1 = lines.count { it.first.meetsPolicy(it.second) }
    println("Part1 = $part1")
}