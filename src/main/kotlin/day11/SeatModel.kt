package day11

class SeatModel(
    private val seats: List<List<SeatState>>
) {
    val rowCount: Int
        get() = seats.size

    val colCount: Int
        get() = seats.first().size

    fun seatState(row: Int, col: Int): SeatState = seats[row][col]

    fun adjacentOccupiedSeats(row: Int, col: Int): Int =
        adjacentSeats(row, col).count {
            seatState(it.first, it.second) == SeatState.TAKEN
        }

    private fun adjacentSeats(row: Int, col: Int): Set<Pair<Int, Int>> =
        (row - 1..row + 1).flatMap { r ->
            (col - 1..col + 1).map { c ->
                r to c
            }
        }.filter { it.first >= 0 }
            .filter { it.second >= 0 }
            .filter { it.first < rowCount }
            .filter { it.second < colCount }
            .filterNot { it.first == row && it.second == col }
            .toSet()

    fun numOccupied(): Int =
        seats.sumBy { row ->
            row.count { it == SeatState.TAKEN }
        }
}