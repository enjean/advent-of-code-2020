package day17

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CoordinateTest {

    @Test
    fun `neighbors returns 26 items`() {
        val expected = setOf(
            Coordinate(x = -1, y = -1, z = 0),
            Coordinate(x = -1, y = 0, z = 0),
            Coordinate(x = -1, y = 1, z = 0),
            Coordinate(x = 0, y = -1, z = 0),
            Coordinate(x = 0, y = 1, z = 0),
            Coordinate(x = 1, y = -1, z = 0),
            Coordinate(x = 1, y = 0, z = 0),
            Coordinate(x = 1, y = 1, z = 0),
            Coordinate(x = -1, y = -1, z = 1),
            Coordinate(x = -1, y = 0, z = 1),
            Coordinate(x = -1, y = 1, z = 1),
            Coordinate(x = 0, y = -1, z = 1),
            Coordinate(x = 0, y = 0, z = 1),
            Coordinate(x = 0, y = 1, z = 1),
            Coordinate(x = 1, y = -1, z = 1),
            Coordinate(x = 1, y = 0, z = 1),
            Coordinate(x = 1, y = 1, z = 1),
            Coordinate(x = -1, y = -1, z = -1),
            Coordinate(x = -1, y = 0, z = -1),
            Coordinate(x = -1, y = 1, z = -1),
            Coordinate(x = 0, y = -1, z = -1),
            Coordinate(x = 0, y = 0, z = -1),
            Coordinate(x = 0, y = 1, z = -1),
            Coordinate(x = 1, y = -1, z = -1),
            Coordinate(x = 1, y = 0, z = -1),
            Coordinate(x = 1, y = 1, z = -1),
        )
        assertEquals(expected, Coordinate(x = 0, y = 0, z = 0).neighbors)
    }
}