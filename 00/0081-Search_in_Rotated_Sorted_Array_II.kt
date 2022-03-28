class Solution {
    
    fun search(nums: IntArray, target: Int): Boolean {
        var left = 0
        var right = nums.size - 1
        
        while (left < right) {
            val mid = left + ((right - left) / 2)

            when {
                nums[mid] == target -> return true
                nums[mid] == nums[right] -> right--
                nums[mid] > nums[right] -> when {
                    target >= nums[left] && target < nums[mid] -> right = mid - 1
                    else -> left = mid + 1
                }
                else -> when {
                    target > nums[mid] && target <= nums[right] -> left = mid + 1
                    else -> right = mid - 1
                }
            }
        }
        
        return nums[left] == target
    }
    
}

fun main() {
    val solution = Solution()
    val output = solution.search(intArrayOf(2, 5, 6, 0, 0, 1, 2), 0)

    println("Expected: true")
    println("Actual  : $output")
}