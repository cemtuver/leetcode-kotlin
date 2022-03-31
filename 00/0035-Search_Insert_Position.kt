class Solution {

    fun searchInsert(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) return 0
        
        var left = 0
        var right = nums.size - 1
        
        while (left <= right) {
            val mid = left + ((right - left) / 2)
            
            when {
                nums[mid] < target -> left = mid + 1
                else -> right = mid - 1
            }
        }
        
        return left
    }

}

fun main() {
    val solution = Solution()
    val output = solution.searchInsert(intArrayOf(1, 3, 5, 6), 5)

    println("Expected: 2")
    println("Actual  : $output")
}
