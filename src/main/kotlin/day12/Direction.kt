package day12

enum class Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    fun turnLeft(degrees: Int): Direction {
        require(degrees % 90 == 0)
        val numTurns = degrees / 90
        val currentIndex = ordinal
        val newIndex = currentIndex - numTurns
        val indexToUse = if (newIndex < 0) values().size + newIndex else newIndex
        return values()[indexToUse]
    }

    fun turnRight(degrees: Int): Direction {
        require(degrees % 90 == 0)
        val numTurns = degrees / 90
        val currentIndex = ordinal
        val newIndex = (currentIndex + numTurns) % values().size
        return values()[newIndex]
    }
}