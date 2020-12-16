package day12

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day12Test {
    private val sampleInstructions = parseInstructions(listOf(
        "F10",
        "N3",
        "F7",
        "R90",
        "F11"
    ))

    @Nested
    inner class PartOne {
        @Test
        fun `F10 would move the ship 10 units east (because the ship starts by facing east) to east 10, north 0`() {
            val result = processInstructions(sampleInstructions.subList(0, 1), initialShipState1)
            assertEquals(Coordinate(10, 0), result.shipCoordinate)
            assertEquals(Direction.EAST, (result as ShipState1).direction)
        }

        @Test
        fun `N3 would move the ship 3 units north to east 10, north 3`() {
            val result = processInstructions(sampleInstructions.subList(0, 2), initialShipState1)
            assertEquals(Coordinate(10, 3), result.shipCoordinate)
            assertEquals(Direction.EAST, (result as ShipState1).direction)
        }

        @Test
        fun `F7 would move the ship another 7 units east (because the ship is still facing east) to east 17, north 3`() {
            val result = processInstructions(sampleInstructions.subList(0, 3), initialShipState1)
            assertEquals(Coordinate(17, 3), result.shipCoordinate)
            assertEquals(Direction.EAST, (result as ShipState1).direction)
        }

        @Test
        fun `R90 would cause the ship to turn right by 90 degrees and face south - it remains at east 17, north 3`() {
            val result = processInstructions(sampleInstructions.subList(0, 4), initialShipState1)
            assertEquals(Coordinate(17, 3), result.shipCoordinate)
            assertEquals(Direction.SOUTH, (result as ShipState1).direction)
        }

        @Test
        fun `F11 would move the ship 11 units south to east 17, south 8`() {
            val result = processInstructions(sampleInstructions, initialShipState1)
            assertEquals(Coordinate(17, -8), result.shipCoordinate)
            assertEquals(Direction.SOUTH, (result as ShipState1).direction)
            assertEquals(25, result.shipCoordinate.manhattanDistanceFromOrigin)
        }
    }

    @Nested
    inner class PartTwo {
        @Test
        fun `full example`() {
            val result = processInstructions(sampleInstructions, initialShipState2)
            assertEquals(Coordinate(214, -72), result.shipCoordinate)
            assertEquals(286, result.shipCoordinate.manhattanDistanceFromOrigin)
        }
    }
}