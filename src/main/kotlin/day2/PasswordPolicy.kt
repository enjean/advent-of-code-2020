package day2

data class PasswordPolicy(
    val letter: Char,
    val num1: Int,
    val num2: Int
) {
    fun meetsPolicy(password: String): Boolean =
        password.count { it == letter } in num1..num2

    fun meetsNewPolicy(password: String): Boolean =
        (password[num1 - 1] == letter).xor(password[num2 - 1] == letter)
}
