class Solution {
    
    fun minFallingPathSum(matrix: Array<IntArray>): Int {
        val n = matrix.size
        val costs = Array(n) { IntArray(n) { Int.MAX_VALUE } }
        
        matrix[n - 1].forEachIndexed { index, cost -> costs[n - 1][index] = cost }
        
        for (i in n - 2 downTo 0) {
            for (j in 0 until n) {
                val minCost = minOf(
                    costs[i + 1].getOrElse(j - 1) { Int.MAX_VALUE },
                    costs[i + 1][j],
                    costs[i + 1].getOrElse(j + 1) { Int.MAX_VALUE }
                )
                
                costs[i][j] = minCost + matrix[i][j]
            }
        }
        
        // return costs[0].min() ?: 0
        return costs[0].minOrNull() ?: 0
    }
    
}

fun main() {
    val solution = Solution()
    val output = solution.minFallingPathSum(
        arrayOf(
            intArrayOf(2, 1, 3),
            intArrayOf(6, 5, 4),
            intArrayOf(7, 8, 9)
        )
    )

    println("Expected: 13")
    println("Actual  : $output")
}