package day5

data class Seat(
    val row: Int,
    val col: Int
) {
    val seatID: Int
        get() = row * 8 + col
}
