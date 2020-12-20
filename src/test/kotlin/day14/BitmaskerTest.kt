package day14

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInAnyOrder
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class BitmaskerTest {
    private val exampleMasker = Bitmasker("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X")

    @Nested
    inner class Mask {
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

    @Nested
    inner class DecodeMemoryAddress {
        @Test
        fun `42 decoded by 000000000000000000000000000000X1001X`() {
            assertThat(
                Bitmasker("000000000000000000000000000000X1001X").decodeMemoryAddress(42),
                containsInAnyOrder(26, 27, 58, 59)
            )
        }

        @Test
        fun `26 decoded by 00000000000000000000000000000001X0XX`() {
//            This results in an address with three floating bits, causing writes to eight memory addresses:
//
//000000000000000000000000000000010000  (decimal 16)
//000000000000000000000000000000010001  (decimal 17)
//000000000000000000000000000000010010  (decimal 18)
//000000000000000000000000000000010011  (decimal 19)
//000000000000000000000000000000011000  (decimal 24)
//000000000000000000000000000000011001  (decimal 25)
//000000000000000000000000000000011010  (decimal 26)
//000000000000000000000000000000011011  (decimal 27)
            assertThat(
                Bitmasker("00000000000000000000000000000001X0XX").decodeMemoryAddress(26),
                containsInAnyOrder(16, 17, 18, 19, 24, 25, 26, 27)
            )
        }
    }
}