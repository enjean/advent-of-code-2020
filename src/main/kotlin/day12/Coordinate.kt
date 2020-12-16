package day12

import kotlin.math.abs

data class Coordinate(
    val eastWest: Int,
    val northSouth: Int
) {
    fun north(value: Int): Coordinate =
        copy(northSouth = northSouth + value)

    fun south(value: Int): Coordinate =
        copy(northSouth = northSouth - value)

    fun east(value: Int): Coordinate =
        copy(eastWest = eastWest + value)

    fun west(value: Int): Coordinate =
        copy(eastWest = eastWest - value)

    fun rotate90DegreesLeft(): Coordinate =
        copy(eastWest = northSouth * -1, northSouth = eastWest)

    fun rotate90DegreesRight(): Coordinate =
        copy(eastWest = northSouth, northSouth = eastWest * -1)

    val manhattanDistanceFromOrigin
        get() = abs(eastWest) + abs(northSouth)
}
