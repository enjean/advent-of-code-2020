package day11

import util.ParseUtil

fun parseSeatModel(input: List<String>): SeatModel =
    SeatModel(input.map { line ->
        line.map {
            when (it) {
                'L' -> SeatState.OPEN
                '.' -> SeatState.FLOOR
                '#' -> SeatState.TAKEN
                else -> throw IllegalArgumentException("Unknown seat value $it")
            }
        }
    })

fun applySeatingRules(seatModel: SeatModel) : Pair<SeatModel, Int> {
    var changed = 0
    val newValues = (0 until seatModel.rowCount).map { row ->
        (0 until seatModel.colCount).map { col ->
            when(seatModel.seatState(row, col)) {
                SeatState.OPEN -> {
                    if (seatModel.adjacentOccupiedSeats(row, col) == 0) {
                        changed++
                        SeatState.TAKEN
                    } else {
                        SeatState.OPEN
                    }
                }
                SeatState.TAKEN -> {
                    if (seatModel.adjacentOccupiedSeats(row, col) >= 4) {
                        changed++
                        SeatState.OPEN
                    } else {
                        SeatState.TAKEN
                    }
                }
                SeatState.FLOOR -> SeatState.FLOOR
            }
        }
    }
    return SeatModel(newValues) to changed
}

tailrec fun modelUntilStatic(seatModel: SeatModel): SeatModel {
    val stepResults = applySeatingRules(seatModel)
    return if (stepResults.second == 0) {
        stepResults.first
    } else {
        modelUntilStatic(stepResults.first)
    }
}

fun main() {
    val initialModel = parseSeatModel(ParseUtil.inputLines(11))

    val stableModel = modelUntilStatic(initialModel)
    println("Part 1 = ${stableModel.numOccupied()}")
}