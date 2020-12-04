package day4

import java.io.File

val requiredKeys = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

fun countValid(input: List<String>): Int {
    val passports = input.fold(PassportParseState()) { passportParseState, line ->
        if (line.isEmpty()) {
            PassportParseState(
                passportsSoFar = passportParseState.passportsSoFar + passportParseState.currentPassport,
                currentPassport = emptyMap()
            )
        } else {
            val newEntries = line.split(" ")
                .map { it.split(":") }
                .map { it[0] to it[1] }
                .toMap()
            PassportParseState(
                passportsSoFar = passportParseState.passportsSoFar,
                currentPassport = passportParseState.currentPassport.plus(newEntries)
            )
        }
    }.passportsSoFar

    return passports.count { passport ->
        requiredKeys.all { passport.containsKey(it) }
    }
}

data class PassportParseState(
    val passportsSoFar: List<Map<String, String>> = emptyList(),
    val currentPassport: Map<String, String> = emptyMap()
)

fun main() {
    val input = File("src/main/resources/day4/input.txt").readLines()
    println("Part 1 = ${countValid(input)}")
}