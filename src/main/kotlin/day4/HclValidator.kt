package day4

object HclValidator : PassportValidator {
    private val regex = """#[0-9a-f]{6}""".toRegex()
    override fun validate(passport: Map<String, String>): Boolean =
        passport["hcl"]?.let { regex.matches(it) } ?: false
}