package day14

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BitmaskerTest {
    private val exampleMasker = Bitmasker("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X")
    @Test
    fun `11 masked by XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X is 73`() {
        assertEquals(73, exampleMasker.mask(11))
    }

    @Test
    fun `101 masked by XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X is unchanged`() {
        assertEquals(101, exampleMasker.mask(101))
    }

    @Test
    fun `0 masked by XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X is 64`() {
        assertEquals(64, exampleMasker.mask(0))
    }
}