class Solution {
            
    fun uniquePaths(m: Int, n: Int): Int {
        val counts = Array(m + 1) { IntArray(n + 1) { 0 } }
        counts[m][n - 1] = 1
        
        for (i in m - 1 downTo 0)  {
            for (j in n - 1 downTo 0) {
                counts[i][j] = counts[i + 1][j] + counts[i][j + 1]  
            }
        }
        
        return counts[0][0]  
    }
    
}

fun main() {
    val solution = Solution()
    val output = solution.uniquePaths(3, 7)

    println("Expected: 28")
    println("Actual  : $output")
}