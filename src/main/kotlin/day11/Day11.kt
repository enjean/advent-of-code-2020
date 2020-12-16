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

fun applyPart1SeatingRules(seatModel: SeatModel) =
    applySeatingRules(seatModel, seatModel::adjacentOccupiedSeats, 4)

fun applyPart2SeatingRules(seatModel: SeatModel) =
    applySeatingRules(seatModel, seatModel::visibleOccupiedSeats, 5)

private fun applySeatingRules(
    seatModel: SeatModel,
    neighborSeatCounter: (Int, Int) -> Int,
    allowedOccupied: Int
): Pair<SeatModel, Int> {
    var changed = 0
    val newValues = (0 until seatModel.rowCount).map { row ->
        (0 until seatModel.colCount).map { col ->
            when (seatModel.seatState(row, col)) {
                SeatState.OPEN -> {
                    if (neighborSeatCounter.invoke(row, col) == 0) {
                        changed++
                        SeatState.TAKEN
                    } else {
                        SeatState.OPEN
                    }
                }
                SeatState.TAKEN -> {
                    if (neighborSeatCounter.invoke(row, col) >= allowedOccupied) {
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

tailrec fun modelUntilStatic(seatModel: SeatModel, seatingRules: (SeatModel) -> Pair<SeatModel, Int>): SeatModel {
    val stepResults = seatingRules.invoke(seatModel)
    return if (stepResults.second == 0) {
        stepResults.first
    } else {
        modelUntilStatic(stepResults.first, seatingRules)
    }
}

fun main() {
    val initialModel = parseSeatModel(ParseUtil.inputLines(11))

    val stableModelPart1 = modelUntilStatic(initialModel, ::applyPart1SeatingRules)
    println("Part 1 = ${stableModelPart1.numOccupied()}")

    val stableModelPart2 = modelUntilStatic(initialModel, ::applyPart2SeatingRules)
    println("Part 2 = ${stableModelPart2.numOccupied()}")
}