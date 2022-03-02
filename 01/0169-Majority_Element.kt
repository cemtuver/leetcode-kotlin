class Solution {
    
    fun majorityElement(nums: IntArray): Int {
        var count = 1
        var majority = nums.first()
        
        nums.drop(1).forEach { num ->
            when {
                majority == num -> count++
                count == 0 -> { 
                    majority = num
                    count = 1
                } 
                else -> count--
            }
        }
        
        return majority
    }
    
}

fun main() {
    val solution = Solution()
    val output = solution.twoSum(intArrayOf(3, 2, 3))

    println("Expected: 3")
    println("Actual  : ${output.toList()}")
}