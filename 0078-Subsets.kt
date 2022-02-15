class Solution {

    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf(emptyList<Int>())
        
        nums.forEach { num ->
            (0 until result.size).forEach { i ->
                result.add(result[i] + num)
            }
        }
        
        return result
    }
    
}


fun main() {
    val solution = Solution()
    val output = solution.subsets(intArrayOf(1, 2, 3))

    println("Expected: [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]")
    println("Actual  : $output")
}
