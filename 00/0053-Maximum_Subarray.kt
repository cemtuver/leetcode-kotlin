class Solution {
    
    fun maxSubArray(nums: IntArray): Int {
        var max = Int.MIN_VALUE
        var leftMax = 0
        
        nums.forEach { num ->
            var current = leftMax + num
            
            max = maxOf(max, current)
            leftMax = maxOf(0, current)
        }
        
        return max
    }
    
}

fun main() {
    val solution = Solution()
    val output = solution.maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4))

    println("Expected: 6")
    println("Actual  : $output")
}