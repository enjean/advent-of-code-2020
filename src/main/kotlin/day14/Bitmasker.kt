package day14

import kotlin.math.pow

class Bitmasker(
   private val mask: String
) {
    private val setterMask =
        mask.replace("X", "0")
            .toLong(2)

    private val eraserMask=
        mask.replace("X", "1")
            .toLong(2)

    fun mask(value: Long) : Long =
        value or setterMask and eraserMask

    fun decodeMemoryAddress(value: Long): List<Long> {
        return mask.reversed().foldIndexed(listOf(0L)) { index, numbersSoFar, maskChar  ->
            numbersSoFar.flatMap { number ->
                when(maskChar) {
                    '0' -> listOf((value and pow2(index)) or number)
                    '1' -> listOf(number or pow2(index))
                    'X' -> listOf(number, number or pow2(index))
                    else -> throw IllegalArgumentException("Invalid char $maskChar")
                }
            }
        }
    }

    private fun pow2(n: Int) : Long =
        (2.0).pow(n).toLong()

}