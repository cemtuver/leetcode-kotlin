class Solution {
    
    fun subArrayRanges(nums: IntArray): Long {
        var sum: Long = 0
        
        for (i in 0 until nums.size) {
            var min = nums[i]
            var max = nums[i]
            
            for (j in i + 1 until nums.size) {
                min = minOf(min, nums[j])
                max = maxOf(max, nums[j])
                sum += max - min
            }
        }
        
        return sum
    }
    
}
 
fun main() {
    val solution = Solution()
    val output = solution.subArrayRanges(intArrayOf(1, 2, 3))

    println("Expected: 4")
    println("Actual  : $output")
}