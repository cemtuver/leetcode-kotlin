class Solution {
    
    private fun solve(matchsticks: IntArray, current: Int, sizes: IntArray): Boolean {
        if (current == matchsticks.size) {
            return sizes.all { it == 0 }
        }
        
        for (i in 0..3) {
            if (sizes[i] < matchsticks[current]) {
                continue
            }
            
            sizes[i] -= matchsticks[current]
            if (solve(matchsticks, current + 1, sizes)) return true            
            sizes[i] += matchsticks[current]
        }
        
        return false
    }
    
    fun makesquare(matchsticks: IntArray): Boolean {
        var sum = matchsticks.sum()
        if (sum % 4 != 0) return false
        val sizes = IntArray(4) { sum / 4 }
        sizes[0] -= matchsticks[0]
        
        return solve(matchsticks, 1, sizes)
    }
    
}

fun main() {
    val solution = Solution()
    val output = solution.makesquare(intArrayOf(1, 1, 2, 2, 2))

    println("Expected: true")
    println("Actual  : $output")
}