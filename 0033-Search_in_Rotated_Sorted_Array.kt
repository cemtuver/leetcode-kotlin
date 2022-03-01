class Solution {
    
    private fun findIndex(nums: IntArray, target: Int, from: Int, to: Int): Int {
        val mid = from + (to - from) / 2
        val midNum = nums[mid]
        
        return when {
            target == midNum -> mid
            from == to -> -1
            nums[from] <= midNum -> {
                when {
                    target >= nums[from] && target < midNum -> findIndex(nums, target, from, mid - 1)
                    else -> findIndex(nums, target, mid + 1, to)
                }
            }
            else -> {
                when {
                    target > midNum && target <= nums[to] -> findIndex(nums, target, mid + 1, to)
                    else -> findIndex(nums, target, from, mid - 1)
                }
            }
        }
    }
    
    fun search(nums: IntArray, target: Int): Int {
        return findIndex(nums, target, 0, nums.size - 1)
    }

}

fun main() {
    val solution = Solution()
    val output = solution.search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0)

    println("Expected: 4")
    println("Actual  : $output")
}