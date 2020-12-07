package day4

interface PassportValidator {
    fun validate(passport: Map<String, String>) : Boolean
}