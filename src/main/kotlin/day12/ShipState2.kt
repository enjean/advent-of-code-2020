package day12

data class ShipState2(
    override val shipCoordinate: Coordinate,
    val waypointCoordinate: Coordinate
) : ShipState {
    override fun north(value: Int): ShipState2 =
        copy(waypointCoordinate = waypointCoordinate.north(value))

    override fun south(value: Int): ShipState2 =
        copy(waypointCoordinate = waypointCoordinate.south(value))

    override fun east(value: Int): ShipState2 =
        copy(waypointCoordinate = waypointCoordinate.east(value))

    override fun west(value: Int): ShipState2 =
        copy(waypointCoordinate = waypointCoordinate.west(value))

    override fun left(degrees: Int): ShipState2 =
        copy(waypointCoordinate = rotate(degrees, Coordinate::rotate90DegreesLeft))

    override fun right(degrees: Int): ShipState2 =
        copy(waypointCoordinate = rotate(degrees, Coordinate::rotate90DegreesRight))

    override fun forward(value: Int): ShipState2 =
        copy(
            shipCoordinate = Coordinate(
                eastWest = shipCoordinate.eastWest + value * waypointCoordinate.eastWest,
                northSouth = shipCoordinate.northSouth + value * waypointCoordinate.northSouth
            )
        )

    private fun rotate(degrees: Int, rotationFunc: (Coordinate) -> Coordinate) : Coordinate {
        require(degrees % 90 == 0)
        val turns = degrees / 90
        return (1..turns).fold(waypointCoordinate) { coord, _ ->
            rotationFunc.invoke(coord)
        }
    }

}
