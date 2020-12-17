package day13

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day13Test {
    @Test
    fun `Earliest Bus Example`() {
        val busIds = parseBusIds("7,13,x,x,59,x,31,19")
        assertEquals(Pair(59, 5), busToCatch(939, busIds))
    }
}