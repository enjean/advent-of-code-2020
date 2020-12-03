package day3

import java.io.File

fun traverseForest(forestLines: List<String>) : Int {
    val forestModel = forestLines.map { line ->
        line.map {
            it == '#'
        }
    }

    var currentColumn = 0
    var treesHit = 0
    for(row in forestModel.indices) {
        if (forestModel[row][currentColumn % forestModel[row].size]) {
            treesHit++
        }
        currentColumn += 3
    }

    return treesHit
}

fun main()  {
    val forestLines = File("src/main/resources/day3/input.txt").readLines()

    println("Part 1 = ${traverseForest(forestLines)}")
}