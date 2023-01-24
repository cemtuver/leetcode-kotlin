class Solution {

    data class State(val square: Int, val steps: Int)

    private fun findNextSquare(board: Array<IntArray>, square: Int): Int {
        val n = board.size
        val row = n - (square - 1) / n - 1
        var column = (square - 1) % n

        if (row % 2 == n % 2) {
            column = n - 1 - column
        }

        return when {
            board[row][column] == -1 -> square
            else -> board[row][column]
        }
    }

    fun snakesAndLadders(board: Array<IntArray>): Int {
        val n = board.size
        val lastSquare = n * n
        val visited = BooleanArray(lastSquare + 1) { false }
        val queue = LinkedList<State>().apply {
            push(State(1, 0))
        }

        while (queue.isNotEmpty()) {
            val state = queue.pop()
            if (state.square == lastSquare) return state.steps

            for (i in 1..minOf(6, lastSquare - state.square)) {
                val newSquare = findNextSquare(board, state.square + i)
                if (visited[newSquare]) continue

                queue.add(State(newSquare, state.steps + 1))
                visited[newSquare] = true
            }
        }

        return -1
    }

}