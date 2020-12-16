package day12

data class ShipState1(
    override val shipCoordinate: Coordinate,
    val direction: Direction,
) : ShipState {
    override fun north(value: Int): ShipState1 =
        copy(shipCoordinate = shipCoordinate.north(value))

    override fun south(value: Int): ShipState1 =
        copy(shipCoordinate = shipCoordinate.south(value))

    override fun east(value: Int): ShipState1 =
        copy(shipCoordinate = shipCoordinate.east(value))

    override fun west(value: Int): ShipState1 =
        copy(shipCoordinate = shipCoordinate.west(value))

    override fun left(degrees: Int): ShipState1 =
        copy(direction = direction.turnLeft(degrees))

    override fun right(degrees: Int): ShipState1 =
        copy(direction = direction.turnRight(degrees))

    override fun forward(value: Int): ShipState1 =
        when (direction) {
            Direction.NORTH -> north(value)
            Direction.SOUTH -> south(value)
            Direction.EAST -> east(value)
            Direction.WEST -> west(value)
        }
}
