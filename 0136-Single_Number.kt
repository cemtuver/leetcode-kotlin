class Solution {
    
    fun singleNumber(nums: IntArray): Int {
        var result = 0
        
        nums.forEach { num ->
            result = result xor num
        }
        
        return result
    }
    
}

fun main() {
    val solution = Solution()
    val output = solution.singleNumber(intArrayOf(4, 1, 2, 1, 2))

    println("Expected: 4")
    println("Actual  : $output")
}
