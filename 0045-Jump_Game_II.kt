class Solution {
    
    fun jump(nums: IntArray): Int {
        var jumps = 0
        var left = 0
        var right = 0
        
        while (right < nums.size - 1) {
            var jump = 0
            
            for (i in left..right) {
                jump = maxOf(jump, i + nums[i])
            }
            
            left = right + 1
            right = jump
            jumps++
        }
        
        return jumps
    }
    
}
 
fun main() {
    val solution = Solution()
    val output = solution.jump(intArrayOf(2, 3, 1, 1, 4))

    println("Expected: 2")
    println("Actual  : $output")
}