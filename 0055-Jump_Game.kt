class Solution {
    
    fun canJump(nums: IntArray): Boolean {
        var current = nums.size - 1
        
        for (i in current - 1 downTo 0) {
            if (nums[i] >= current - i) {
                current = i
            }
        }
        
        return current == 0
    }
    
}

fun main() {
    val solution = Solution()
    val output = solution.canJump(intArrayOf(2, 3, 1, 1, 4))

    println("Expected: true")
    println("Actual  : $output")
}