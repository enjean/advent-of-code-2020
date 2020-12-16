package day12

interface ShipState {
    val shipCoordinate: Coordinate

    fun north(value: Int): ShipState

    fun south(value: Int): ShipState

    fun east(value: Int): ShipState

    fun west(value: Int): ShipState

    fun left(degrees: Int): ShipState

    fun right(degrees: Int): ShipState

    fun forward(value: Int): ShipState
}