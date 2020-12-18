package day14

class Bitmasker(
    mask: String
) {
    private val setterMask =
        mask.replace("X", "0")
            .toLong(2)

    private val eraserMask=
        mask.replace("X", "1")
            .toLong(2)

    fun mask(value: Long) : Long =
        value or setterMask and eraserMask
}