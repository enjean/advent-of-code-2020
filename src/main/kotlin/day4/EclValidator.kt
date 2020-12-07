package day4

object EclValidator : PassportValidator {
    private val allowedValues = setOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")

    override fun validate(passport: Map<String, String>): Boolean =
        passport["ecl"]?.let { allowedValues.contains(it) } ?: false
}