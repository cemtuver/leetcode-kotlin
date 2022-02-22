class Solution {
    
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val m = triangle.size
        val costs = Array(m) { i -> IntArray(m) { j -> triangle[i].getOrElse(j) { 0 } } }

        for (i in m - 2 downTo 0) {
            for (j in 0..i) {
                costs[i][j] = triangle[i][j] + minOf(costs[i + 1][j], costs[i + 1][j + 1])
            }
        }
        
        return costs[0][0]
    }
    
}

fun main() {
    val solution = Solution()
    val output = solution.minimumTotal(listOf(listOf(2) ,listOf(3,4) ,listOf(6,5,7) ,listOf(4,1,8,3)))

    println("Expected: 11")
    println("Actual  : $output")
}
