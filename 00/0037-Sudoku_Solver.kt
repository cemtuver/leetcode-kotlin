class Solution {

    val rowMaps = Array(9) { mutableSetOf<Char>() }
    val columnMaps = Array(9) { mutableSetOf<Char>() }
    val squareMaps = Array(9) { mutableSetOf<Char>() }
    val emptyCells = mutableListOf<Pair<Int, Int>>()
    lateinit var board: Array<CharArray>

    fun squareIndex(row: Int, column: Int): Int {
        return (row / 3) * 3 + (column / 3)
    }

    fun setupSets() {
        for (row in 0..8) {
            for (column in 0..8) {
                if (board[row][column] == '.') {
                    emptyCells.add(Pair(row, column))
                } else {
                    fill(row, column, board[row][column])
                }
            }
        }
    }

    fun canFill(row: Int, column: Int, char: Char): Boolean {
        return !rowMaps[row].contains(char) &&
            !columnMaps[column].contains(char) &&
            !squareMaps[squareIndex(row, column)].contains(char)
    }

    fun fill(row: Int, column: Int, char: Char) {
        board[row][column] = char
        rowMaps[row].add(char)
        columnMaps[column].add(char)
        squareMaps[squareIndex(row, column)].add(char)
    }

    fun clear(row: Int, column: Int, char: Char) {
        board[row][column] = '.'
        rowMaps[row].remove(char)
        columnMaps[column].remove(char)
        squareMaps[squareIndex(row, column)].remove(char)
    }

    fun solveBoard(iteration: Int): Boolean {
        if (iteration == emptyCells.size) {
            return true
        }

        val (row, column) = emptyCells[iteration]

        for (number in 0..8) {
            val char = (number + 49).toChar()

            if (canFill(row, column, char)) {
                fill(row, column, char)
                
                if (solveBoard(iteration + 1)) {
                    board[row][column] = char
                    return true
                } else {
                    clear(row, column, char)
                }
            }
        }

        return false
    }

    fun solveSudoku(board: Array<CharArray>): Unit {
        this.board = board
        setupSets()
        solveBoard(0)
    }

}