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

fun main() {
    val seats = File("src/main/resources/day5/input.txt").readLines()
        .map { toSeat(it) }

    println("Part 1: ${seats.maxOf { it.seatID }}")
}