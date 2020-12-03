package day3

import java.io.File

fun traverseForest(forestLines: List<String>, right: Int, down: Int) : Int {
    val forestModel = forestLines.map { line ->
        line.map {
            it == '#'
        }
    }

    var currentRow = 0
    var currentColumn = 0
    var treesHit = 0
    while(currentRow < forestModel.size) {
        if (forestModel[currentRow][currentColumn % forestModel[currentRow].size]) {
            treesHit++
        }
        currentRow += down
        currentColumn += right
    }

    return treesHit
}

fun main()  {
    val forestLines = File("src/main/resources/day3/input.txt").readLines()

    val right3Down1 = traverseForest(forestLines, 3, 1)
    println("Part 1 = $right3Down1")

    val right1Down1 = traverseForest(forestLines, 1, 1)
    val right5Down1 = traverseForest(forestLines, 5, 1)
    val right7Down1 = traverseForest(forestLines, 7, 1)
    val right1Down2 = traverseForest(forestLines, 1, 2)
    println("Part 2 = ${right1Down1 * right3Down1 * right5Down1 * right7Down1 * right1Down2}")
}