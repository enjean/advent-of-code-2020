package day18

import util.ParseUtil
import java.io.StreamTokenizer
import java.io.StringReader

fun evaluateExpression(expression: String): Long =
    evaluateExpression(StreamTokenizer(StringReader(expression)))

private fun evaluateExpression(tokenizer: StreamTokenizer): Long {
    val lhs = evaluateFactor(tokenizer)
    var value = lhs
    var currentToken = tokenizer.nextToken()
    while(currentToken != StreamTokenizer.TT_EOF && currentToken.toChar() != ')') {
        val operand = currentToken.toChar()
        val rhs = evaluateFactor(tokenizer)
        when(operand) {
            '+' -> value += rhs
            '-' -> value -= rhs
            '*' -> value *= rhs
            '/' -> value /= rhs
            else -> throw IllegalArgumentException("Invalid operand $operand")
        }
        currentToken = tokenizer.nextToken()
    }
    return value
}

private fun evaluateFactor(tokenizer: StreamTokenizer): Long {
    val token = tokenizer.nextToken()
    return when {
        tokenizer.ttype == StreamTokenizer.TT_NUMBER -> tokenizer.nval.toLong()
        token.toChar() == '(' -> evaluateExpression(tokenizer)
        else -> throw IllegalArgumentException("Unexpected token $token")
    }
}

fun main() {
    val part1 = ParseUtil.inputLines(18).map { line -> evaluateExpression(line) }.sum()
    println("Part 1 = $part1")
}