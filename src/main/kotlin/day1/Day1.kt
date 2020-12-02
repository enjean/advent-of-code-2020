package day1

import java.io.File

fun find2NumbersThatSum(numbers: List<Int>): Pair<Int, Int> {
    for(i in numbers.indices) {
        for(j in i+1 until numbers.size) {
            if (numbers[i] + numbers[j] == 2020) {
                return numbers[i] to numbers[j]
            }
        }
    }
    throw IllegalArgumentException("No match")
}

fun find3NumbersThatSum(numbers: List<Int>): Triple<Int, Int, Int> {
    for(i in numbers.indices) {
        for(j in i+1 until numbers.size) {
            for (k in j + 1 until numbers.size) {
                if (numbers[i] + numbers[j] + numbers[k] == 2020) {
                    return Triple(numbers[i], numbers[j], numbers[k])
                }
            }
        }
    }
    throw IllegalArgumentException("No match")
}

fun main() {
    val numbers = File("src/main/resources/day1/input.txt").readLines()
        .map { it.toInt() }

    val part1 = find2NumbersThatSum(numbers)
    println("Part 1 = ${part1.first * part1.second}")


    val part2 = find3NumbersThatSum(numbers)
    println("Part 2 = ${part2.first * part2.second * part2.third}")
}