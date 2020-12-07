package day4

open class YearValidator(
    private val field: String,
    private val min: Int,
    private val max: Int
) : PassportValidator {
    private val regex = """^[\d]{4}$""".toRegex()
    override fun validate(passport: Map<String, String>): Boolean =
        passport[field]?.let {
            regex.matches(it) && it.toInt() in min..max
        } ?: false
}
