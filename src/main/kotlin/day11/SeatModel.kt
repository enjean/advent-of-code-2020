package day11

class SeatModel(
    private val seats: List<List<SeatState>>
) {
    private val neighborDirections = listOf(
        -1 to -1,
        -1 to 0,
        -1 to 1,
        0 to -1,
        0 to 1,
        1 to -1,
        1 to 0,
        1 to 1
    )

    val rowCount: Int
        get() = seats.size

    val colCount: Int
        get() = seats.first().size

    fun seatState(row: Int, col: Int): SeatState = seats[row][col]

    fun adjacentOccupiedSeats(row: Int, col: Int): Int =
        occupiedSeats(row, col, ::adjacentSeatInDirection)

    fun visibleOccupiedSeats(row: Int, col: Int): Int =
        occupiedSeats(row, col, ::firstVisibleSeatInDirection)

    private fun occupiedSeats(row: Int, col: Int, seatFinder: (Int, Int, Pair<Int, Int>) -> SeatState?) =
        neighborDirections
            .mapNotNull { seatFinder(row, col, it) }
            .count { it == SeatState.TAKEN }

    private fun adjacentSeatInDirection(row: Int, col: Int, direction: Pair<Int, Int>): SeatState? {
        val targetRow = row + direction.first
        val targetCol = col + direction.second
        return if (isValidSeat(targetRow, targetCol)) seatState(targetRow, targetCol) else null
    }

    private tailrec fun firstVisibleSeatInDirection(row: Int, col: Int, direction: Pair<Int, Int>): SeatState? {
        val targetRow = row + direction.first
        val targetCol = col + direction.second
        if (!isValidSeat(targetRow, targetCol)) {
            return null
        }
        val targetSeatState = seatState(targetRow, targetCol)
        return if (targetSeatState == SeatState.FLOOR) {
            firstVisibleSeatInDirection(targetRow, targetCol, direction)
        } else {
            targetSeatState
        }
    }

    private fun isValidSeat(row: Int, col: Int) =
        row in 0 until rowCount && col in 0 until colCount

    fun numOccupied(): Int =
        seats.sumBy { row ->
            row.count { it == SeatState.TAKEN }
        }
}