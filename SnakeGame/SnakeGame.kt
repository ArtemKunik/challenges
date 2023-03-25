import java.util.*
import java.io.IOException
import kotlin.ranges.until
data class Position(val x: Int, val y: Int)

enum class Direction { UP, DOWN, LEFT, RIGHT }

class SnakeGame(private val size: Int, private val startPos: Position) {
    var body: LinkedList<Position> = LinkedList()

    init {
        for (i in 0 until size) {
            body.add(Position(startPos.x - i, startPos.y))
        }
    }

    fun move(direction: Direction) {
        val head = body.first
        val newHead = when (direction) {
            Direction.UP -> Position(head.x, head.y - 1)
            Direction.DOWN -> Position(head.x, head.y + 1)
            Direction.LEFT -> Position(head.x - 1, head.y)
            Direction.RIGHT -> Position(head.x + 1, head.y)
        }
        body.addFirst(newHead)
        body.removeLast()
    }

    fun grow() {
        val tail = body.last
        val newTail = Position(tail.x, tail.y)
        body.addLast(newTail)
    }

    fun contains(position: Position): Boolean {
        return body.contains(position)
    }
}

class Game(private val width: Int, private val height: Int) {
    private var snake: SnakeGame = SnakeGame(3, Position(width / 2, height / 2))
    private var food: Position = randomPosition()

    fun run() {
        var direction = Direction.RIGHT
        while (true) {
            printBoard()
            val input = readKey()
            when (input) {
                'W' -> direction = Direction.UP
            }
            when (input) {
                'S' -> direction = Direction.DOWN
            }
            when (input) {
                'A' -> direction = Direction.LEFT
            }
            when (input) {
                'D' -> direction = Direction.RIGHT
            }
            snake.move(direction)
            if (snake.contains(food)) {
                snake.grow()
                food = randomPosition()
            }
            if (isGameOver()) {
                println("Game over!")
                return
            }
        }
    }

    private fun printBoard() {
        for (y in 0 until height) {
            for (x in 0 until width) {
                val position = Position(x, y)
                if (snake.contains(position)) {
                    print("O")
                } else if (position == food) {
                    print("X")
                } else {
                    print(".")
                }
            }
            println()
        }
    }

    private fun isGameOver(): Boolean {
        val head = snake.body.first
        if (head.x < 0 || head.x >= width || head.y < 0 || head.y >= height) {
            return true
        }
        val tail = snake.body.subList(1, snake.body.size)
        if (snake.contains(head) && tail.contains(head)) {
            return true
        }
        return false
    }

    private fun randomPosition(): Position {
        val random = Random()
        var position: Position
        do {
            position = Position(random.nextInt(width), random.nextInt(height))
        } while (snake.contains(position))
        return position
    }

    fun readKey(): Char {
        var ch: Char = '\u0000'
        try {
            val input = System.`in`.read()
            ch = input.toChar()
        } catch (e: IOException) {
            // Handle the exception if needed
        }
        return ch
    }
}

fun main(args: Array<String>) {
    val game = Game(20, 10)
    game.run()
}
