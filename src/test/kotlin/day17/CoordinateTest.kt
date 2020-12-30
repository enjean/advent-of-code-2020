package day17

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CoordinateTest {

    @Test
    fun `3D neighbors returns 26 coordinates`() {
        val expected = setOf(
            Coordinate(listOf(-1, -1, 0)),
            Coordinate(listOf(-1, 0, 0)),
            Coordinate(listOf(-1, 1, 0)),
            Coordinate(listOf(0, -1, 0)),
            Coordinate(listOf(0, 1, 0)),
            Coordinate(listOf(1, -1, 0)),
            Coordinate(listOf(1, 0, 0)),
            Coordinate(listOf(1, 1, 0)),
            Coordinate(listOf(-1, -1, 1)),
            Coordinate(listOf(-1, 0, 1)),
            Coordinate(listOf(-1, 1, 1)),
            Coordinate(listOf(0, -1, 1)),
            Coordinate(listOf(0, 0, 1)),
            Coordinate(listOf(0, 1, 1)),
            Coordinate(listOf(1, -1, 1)),
            Coordinate(listOf(1, 0, 1)),
            Coordinate(listOf(1, 1, 1)),
            Coordinate(listOf(-1, -1, -1)),
            Coordinate(listOf(-1, 0, -1)),
            Coordinate(listOf(-1, 1, -1)),
            Coordinate(listOf(0, -1, -1)),
            Coordinate(listOf(0, 0, -1)),
            Coordinate(listOf(0, 1, -1)),
            Coordinate(listOf(1, -1, -1)),
            Coordinate(listOf(1, 0, -1)),
            Coordinate(listOf(1, 1, -1)),
        )
        assertEquals(expected, Coordinate(listOf(0, 0, 0)).neighbors)
    }

    @Test
    fun `4D Neighbors returns 80 coordinates`() {
        assertEquals(80, Coordinate(listOf(0, 0, 0, 0)).neighbors.size)
    }
}