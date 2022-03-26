class Solution {
    
    private fun insertIndex(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        
        while (left < right) {
            val mid = left + ((right - left) / 2)
            
            when {
                nums[mid] < target -> left = mid + 1
                else -> right = mid
            }
        }
        
        return left
    }

    fun searchRange(nums: IntArray, target: Int): IntArray {
        if (nums.isEmpty()) return intArrayOf(-1, -1)
        
        val left = insertIndex(nums, target)
        val right = insertIndex(nums, target + 1)
        
        return when {
            nums[left] != target -> intArrayOf(-1, -1)
            nums[right] != target -> intArrayOf(left, right - 1)
            else -> intArrayOf(left, right)
        }
    }

}

fun main() {
    val solution = Solution()
    val output = solution.searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8)

    println("Expected: [3, 4]")
    println("Actual  : ${output.toList()}")
}