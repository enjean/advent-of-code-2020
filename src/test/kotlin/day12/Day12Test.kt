package day12

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day12Test {
    private val sampleInstructions = parseInstructions(listOf(
        "F10",
        "N3",
        "F7",
        "R90",
        "F11"
    ))

    @Test
    fun `F10 would move the ship 10 units east (because the ship starts by facing east) to east 10, north 0`() {
        val result = processInstructions(sampleInstructions.subList(0, 1))
        assertEquals(0, result.northSouth)
        assertEquals(10, result.eastWest)
        assertEquals(Direction.EAST, result.direction)
    }

    @Test
    fun `N3 would move the ship 3 units north to east 10, north 3`() {
        val result = processInstructions(sampleInstructions.subList(0, 2))
        assertEquals(-3, result.northSouth)
        assertEquals(10, result.eastWest)
        assertEquals(Direction.EAST, result.direction)
    }

    @Test
    fun `F7 would move the ship another 7 units east (because the ship is still facing east) to east 17, north 3`() {
        val result = processInstructions(sampleInstructions.subList(0, 3))
        assertEquals(-3, result.northSouth)
        assertEquals(17, result.eastWest)
        assertEquals(Direction.EAST, result.direction)
    }

    @Test
    fun `R90 would cause the ship to turn right by 90 degrees and face south - it remains at east 17, north 3`() {
        val result = processInstructions(sampleInstructions.subList(0, 4))
        assertEquals(-3, result.northSouth)
        assertEquals(17, result.eastWest)
        assertEquals(Direction.SOUTH, result.direction)
    }

    @Test
    fun `F11 would move the ship 11 units south to east 17, south 8`() {
        val result = processInstructions(sampleInstructions)
        assertEquals(8, result.northSouth)
        assertEquals(17, result.eastWest)
        assertEquals(Direction.SOUTH, result.direction)
        assertEquals(25, result.manhattanDistanceFromOrigin)
    }
}