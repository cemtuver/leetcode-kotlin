class Solution {
    
    fun minPathSum(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val cost = Array(m + 1) { IntArray(n + 1) { Int.MAX_VALUE } }
        cost[m][n - 1] = 0
        
        for (i in m - 1 downTo 0) {
            for (j in n - 1 downTo 0) {
                cost[i][j] = grid[i][j] + minOf(cost[i + 1][j], cost[i][j + 1])
            }
        }
        
        return cost[0][0]
    }
    
}

fun main() {
    val solution = Solution()
    val output = solution.minPathSum(arrayOf(intArrayOf(1, 3, 1), intArrayOf(1, 5, 1), intArrayOf(4, 2, 1)))

    println("Expected: 7")
    println("Actual  : $output")
}