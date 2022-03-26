class Solution {
    
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val columns = matrix.first().size
        var left = 0
        var right = matrix.size * columns - 1
        
        while (left < right) {
            val mid = (left + right - 1) / 2
            val midItem = matrix[mid / columns][mid % columns]
            
            when {
                midItem < target -> left = mid + 1
                else -> right = mid
            }
        }
        
        return matrix[right / columns][right % columns] == target
    }
    
}

fun main() {
    val solution = Solution()
    val output = solution.searchMatrix(arrayOf(intArrayOf(1, 3, 5, 7), intArrayOf(10, 11, 16, 20), intArrayOf(23, 30, 34, 60)), 3)

    println("Expected: true")
    println("Actual  : $output")
}