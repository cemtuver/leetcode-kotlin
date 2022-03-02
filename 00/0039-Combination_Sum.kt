class Solution {
    
    private val result = mutableListOf<List<Int>>()

    private fun dfs(candidates: IntArray, current: MutableList<Int>, from: Int, target: Int) {
        if (target == 0) {
            result.add(current.toList())
            return
        }
        
        for (i in from until candidates.size) {
            if (candidates[i] > target) continue
            
            current.add(candidates[i])
            dfs(candidates, current, i, target - candidates[i])
            current.removeAt(current.size - 1)
        }
    }
    
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        dfs(candidates, mutableListOf(), 0, target)
        return result
    }

}

fun main() {
    val solution = Solution()
    val output = solution.combinationSum(intArrayOf(2, 3, 6, 7), 7)

    println("Expected: [[2, 2, 3], [7]]")
    println("Actual  : $output")
}