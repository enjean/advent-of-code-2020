package day4

object HasRequiredFieldsValidator :PassportValidator {
    private val requiredKeys = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

    override fun validate(passport: Map<String, String>): Boolean =
        requiredKeys.all { passport.containsKey(it) }

}