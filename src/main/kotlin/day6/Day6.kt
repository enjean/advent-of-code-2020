package day6

import util.ParseUtil
import java.io.File

fun uniqueQuestions(groupAnswerLines: List<String>) : Int =
    groupAnswerLines.fold(emptySet<Char>()) { questions, line ->
        questions.plus(line.toSet())
    }.size

fun totalUniqueQuestions(lines: List<String>): Int =
    ParseUtil.parseGroups(lines)
        .map { uniqueQuestions(it) }
        .sum()

fun main() {
    val lines = File("src/main/resources/day6/input.txt").readLines()

    println("Part 1 = ${totalUniqueQuestions(lines)}")
}