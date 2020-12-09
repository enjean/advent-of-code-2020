package util

import java.io.File

object ParseUtil {
    fun inputLines(day: Int) =
        File("src/main/resources/day$day/input.txt").readLines()

    fun parseGroups(lines: List<String>) : List<List<String>> =
        lines.fold(ParseGroupState()) { parseGroupState, line ->
            if(line.isEmpty()) {
                parseGroupState.finishGroup()
            } else {
                parseGroupState.addToGroup(line)
            }
        }.finishGroup().groups

    private data class ParseGroupState(
        val groups: List<List<String>> = emptyList(),
        private val currentGroup: List<String> = emptyList()
    ) {
        fun finishGroup(): ParseGroupState =
            ParseGroupState(groups.plus(element = currentGroup), emptyList())
        fun addToGroup(line: String): ParseGroupState =
            ParseGroupState(groups, currentGroup + line)
    }
}