class Solution {
    
    fun moveZeroes(nums: IntArray): Unit {
        if (nums.size <= 1) return

        var index = 0
        
        nums.forEach { num ->
            if (num != 0) {
                nums[index++] = num
            }
        }
        
        for (i in index until nums.size) {
            nums[i] = 0
        }
    }
    
}

fun main() {
    val solution = Solution()
    val input = intArrayOf(0, 1, 0, 3, 12)
    solution.moveZeroes(input)

    println("Expected: [1, 3, 12, 0, 0]")
    println("Actual  : ${input.toList()}")
}