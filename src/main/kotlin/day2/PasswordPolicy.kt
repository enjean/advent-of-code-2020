package day2

data class PasswordPolicy(
    val letter: Char,
    val minTimes: Int,
    val maxTimes: Int
) {
    fun meetsPolicy(password: String): Boolean =
        password.count { it == letter } in minTimes..maxTimes
}
