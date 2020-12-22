package day15

data class GameState(
    val spoken: Int,
    val turnNumber: Int,
    val turnLastSpoken: Map<Int, Int>
)

fun playGame(startingNumbers: List<Int>): Int =
    numberSpoken(initializeGameState(startingNumbers), 2020)

private tailrec fun numberSpoken(gameState: GameState, turnToStop: Int): Int =
    if (gameState.turnNumber == turnToStop) {
        gameState.spoken
    } else {
        numberSpoken(takeTurn(gameState), turnToStop)
    }

private fun initializeGameState(startingNumbers: List<Int>): GameState {
    val turnLastSpoken = (0 until startingNumbers.size - 1).map { index ->
        startingNumbers[index] to index + 1
    }.toMap()
    return GameState(
        spoken = startingNumbers.last(),
        turnNumber = startingNumbers.size,
        turnLastSpoken = turnLastSpoken
    )
}

private fun takeTurn(gameState: GameState): GameState {
    val valueToSpeak = gameState.turnLastSpoken[gameState.spoken]?.let { gameState.turnNumber - it } ?: 0
    return GameState(
        spoken = valueToSpeak,
        turnNumber = gameState.turnNumber + 1,
        turnLastSpoken = gameState.turnLastSpoken + (gameState.spoken to gameState.turnNumber)
    )
}

fun main() {
    val input = listOf(2, 20, 0, 4, 1, 17)

    println("Part 1 = ${playGame(input)}")
}