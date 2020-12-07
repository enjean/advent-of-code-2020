package day4

object PidValidator : PassportValidator {
    private val regex = """^[\d]{9}$""".toRegex()
    override fun validate(passport: Map<String, String>): Boolean =
        passport["pid"]?.let { regex.matches(it) } ?: false

}