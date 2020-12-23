package day15

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day15Test {
    @Nested
    inner class PlayShortGame {
        @Test
        fun `Given the starting numbers 0,3,6, the 2020th number spoken is 436`() {
            assertEquals(436, playGameMutable(listOf(0, 3, 6), 2020))
        }

        @Test
        fun `Given the starting numbers 1,3,2, the 2020th number spoken is 1`() {
            assertEquals(1, playGame(listOf(1, 3, 2), 2020))
        }

        @Test
        fun `Given the starting numbers 2,1,3, the 2020th number spoken is 10`() {
            assertEquals(10, playGame(listOf(2, 1, 3), 2020))
        }

        @Test
        fun `Given the starting numbers 1,2,3, the 2020th number spoken is 27`() {
            assertEquals(27, playGame(listOf(1, 2, 3), 2020))
        }

        @Test
        fun `Given the starting numbers 2,3,1, the 2020th number spoken is 78`() {
            assertEquals(78, playGame(listOf(2, 3, 1), 2020))
        }

        @Test
        fun `Given the starting numbers 3,2,1, the 2020th number spoken is 438`() {
            assertEquals(438, playGame(listOf(3, 2, 1), 2020))
        }

        @Test
        fun `Given the starting numbers 3,1,2, the 2020th number spoken is 1836`() {
            assertEquals(1836, playGame(listOf(3, 1, 2), 2020))
        }
    }

    @Nested
    inner class PlayLongGame {
        @Test
        fun `Given 0,3,6, the 30000000th number spoken is 175594`() {
            assertEquals(175594, playGameMutable(listOf(0, 3, 6), 30000000))
        }

        @Test
        fun `Given 1,3,2, the 30000000th number spoken is 2578`() {
            assertEquals(2578, playGameMutable(listOf(1,3,2), 30000000))
        }

    }
}