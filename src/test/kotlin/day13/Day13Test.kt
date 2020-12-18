package day13

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day13Test {
    private val busIds = parseBusIds("7,13,x,x,59,x,31,19")

    @Test
    fun `Earliest Bus Example`() {
        assertEquals(Pair(59, 5), busToCatch(939, busIds))
    }

    @Nested
    inner class TimeMatchingOffsets {
        @Test
        fun `First example`() {
            assertEquals(1068781, timeMatchingOffsets(busIds))
        }

        @Test
        fun `simple example`() {
            //println("${firstMatch(7, 13, 1)}")
            assertEquals(77, timeMatchingOffsets(parseBusIds("7,13")))
        }

        @Test
        fun `The earliest timestamp that matches the list 17,x,13,19 is 3417`() {
            assertEquals(3417, timeMatchingOffsets(parseBusIds("17,x,13,19")))
        }

        @Test
        fun `67,7,59,61 first occurs at timestamp 754018`() {
            assertEquals(754018, timeMatchingOffsets(parseBusIds("67,7,59,61")))
        }

        @Test
        fun `67,x,7,59,61 first occurs at timestamp 779210`() {
            assertEquals(779210, timeMatchingOffsets(parseBusIds("67,x,7,59,61")))
        }

        @Test
        fun `67,7,x,59,61 first occurs at timestamp 1261476`() {
            assertEquals(1261476, timeMatchingOffsets(parseBusIds("67,7,x,59,61")))
        }

        @Test
        fun `1789,37,47,1889 first occurs at timestamp 1202161486`() {
            assertEquals(1202161486, timeMatchingOffsets(parseBusIds("1789,37,47,1889")))
        }
    }

}