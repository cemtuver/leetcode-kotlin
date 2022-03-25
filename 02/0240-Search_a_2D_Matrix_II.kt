class Solution {
    
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var rows = matrix.size
        var columns = matrix.first().size
        
        var row = rows - 1
        var column = 0
        
        while (row >= 0 && column < columns) {
            if (matrix[row][column] == target) {
                return true
            }
            
            when {
                target < matrix[row][column] -> row--
                else -> column++
            }
        }
        
        return false
    }

}

fun main() {
    val solution = Solution()
    val output = solution.searchMatrix(arrayOf(intArrayOf(5), intArrayOf(6)), 6)

    println("Expected: true")
    println("Actual  : $output")
}
