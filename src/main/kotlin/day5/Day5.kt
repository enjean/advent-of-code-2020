package day5

import java.io.File

fun toSeat(seatSpec: String) : Seat =
    Seat(findRow(seatSpec.substring(0, 7)), findColumn(seatSpec.substring(7)))

private fun findRow(rowString: String) : Int = findValue(rowString, 0, 127, 'F')
private fun findColumn(colString: String) : Int = findValue(colString, 0, 7, 'L')

private tailrec fun findValue(instructions: String, min: Int, max: Int, lowerChar: Char) : Int{
    val instruction = instructions.first()
    if (instructions.length == 1) {
        return if(instruction == lowerChar) min else max
    } else {
        val median = (min + max) / 2
        return if(instruction == lowerChar) {
            findValue(instructions.substring(1), min, median, lowerChar)
        }
        else {
            findValue(instructions.substring(1), median + 1, max, lowerChar)
        }
    }
}

fun missingSeat(seatIDs: List<Int>) : Int {
    val sorted = seatIDs.sorted()
    sorted.forEachIndexed { index, value ->
        if (index != 0 && sorted[index - 1] != value - 1) {
            return value - 1
        }
    }
    throw RuntimeException("Didn't find")
}

fun main() {
    val seatIDs = File("src/main/resources/day5/input.txt").readLines()
        .map { toSeat(it).seatID }

    val max = seatIDs.maxOrNull()!!
    println("Part 1: $max")

    println("Part 2: ${missingSeat(seatIDs)}")
}