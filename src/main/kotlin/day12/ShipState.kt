package day12

import kotlin.math.abs

data class ShipState(
    val northSouth: Int,
    val eastWest: Int,
    val direction: Direction
) {
    fun north(value: Int): ShipState =
        copy(northSouth = northSouth - value)

    fun south(value: Int): ShipState =
        copy(northSouth = northSouth + value)

    fun east(value: Int): ShipState =
        copy(eastWest = eastWest + value)

    fun west(value: Int): ShipState =
        copy(eastWest = eastWest - value)

    fun left(degrees: Int): ShipState =
        copy(direction = direction.turnLeft(degrees))

    fun right(degrees: Int): ShipState =
        copy(direction = direction.turnRight(degrees))

    fun forward(value: Int): ShipState =
        when (direction) {
            Direction.NORTH -> north(value)
            Direction.SOUTH -> south(value)
            Direction.EAST -> east(value)
            Direction.WEST -> west(value)
        }

    val manhattanDistanceFromOrigin
        get() = abs(northSouth) + abs(eastWest)
}
