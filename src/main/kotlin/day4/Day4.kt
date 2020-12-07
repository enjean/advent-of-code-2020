package day4

import java.io.File

val part1Validators = listOf(HasRequiredFieldsValidator)
val part2Validators = listOf(
    HasRequiredFieldsValidator,
    ByrValidator,
    IyrValidator,
    EyrValidator,
    HgtValidator,
    HclValidator,
    EclValidator,
    PidValidator
)

fun parsePassports(input: List<String>): List<Map<String, String>> {
    val resultState = input.fold(PassportParseState()) { passportParseState, line ->
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
    }
    return resultState.passportsSoFar + resultState.currentPassport
}

fun countValid(passports: List<Map<String, String>>, validators: List<PassportValidator>) =
    passports.count { passport -> validators.all { validator -> validator.validate(passport) } }

data class PassportParseState(
    val passportsSoFar: List<Map<String, String>> = emptyList(),
    val currentPassport: Map<String, String> = emptyMap()
)

fun main() {
    val input = File("src/main/resources/day4/input.txt").readLines()
    val passports = parsePassports(input)
    println("Part 1 = ${countValid(passports, part1Validators)}")

    println("Part 2 = ${countValid(passports, part2Validators)}")
}