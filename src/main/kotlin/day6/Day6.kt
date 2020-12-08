package day6

import util.ParseUtil
import java.io.File

fun uniqueQuestions(groupAnswerLines: List<String>): Int =
    groupAnswerLines.fold(emptySet<Char>()) { questions, line ->
        questions.plus(line.toSet())
    }.size

fun allAnsweredYes(groupAnswerLines: List<String>): Int =
    groupAnswerLines.first()
        .count { questionChar ->
            groupAnswerLines.all { answerLine -> answerLine.contains(questionChar) }
        }


fun totalUniqueQuestions(groupAnswers: List<List<String>>): Int =
    groupAnswers
        .map { uniqueQuestions(it) }
        .sum()

fun totalAllAnswered(groupAnswers: List<List<String>>): Int =
    groupAnswers
        .map { allAnsweredYes(it) }
        .sum()

fun main() {
    val groups = ParseUtil.parseGroups(File("src/main/resources/day6/input.txt").readLines())

    println("Part 1 = ${totalUniqueQuestions(groups)}")
    println("Part 2 = ${totalAllAnswered(groups)}")
}