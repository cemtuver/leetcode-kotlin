class Solution {
    
    private val result = mutableListOf<List<Int>>()
    
    private fun dfs(nums: IntArray, current: MutableList<Int>, used: MutableSet<Int>) {
        if (used.size == nums.size) {
            result.add(current.toList())
            return
        }
        
        nums.forEach { num ->
            if (used.contains(num)) {
                return@forEach
            }
            
            current.add(num)
            used.add(num)
            dfs(nums, current, used)
            current.removeAt(current.size - 1)
            used.remove(num)
        }
    }
    
    fun permute(nums: IntArray): List<List<Int>> {
        dfs(nums, mutableListOf(), mutableSetOf())
        return result
    }
    
}

fun main() {
    val solution = Solution()
    val output = solution.permute(intArrayOf(1, 2, 3))

    println("Expected: [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]")
    println("Actual  : $output")
}