package day4

object HgtValidator: PassportValidator {
    private val inchesRegex = """(\d+)in""".toRegex()
    private val cmRegex = """(\d+)cm""".toRegex()

    override fun validate(passport: Map<String, String>): Boolean =
        passport["hgt"]?.let { hgtVal ->
            inchesRegex.matchEntire(hgtVal)?.let { inchesMatch ->
                inchesMatch.groupValues[1].toInt() in 59..76
            } ?: cmRegex.matchEntire(hgtVal)?.let { cmMatch ->
                cmMatch.groupValues[1].toInt() in 150..193
            }
        } ?: false

}