class Solution {

    fun subarraySum(nums: IntArray, k: Int): Int {
        if (nums.size == 0) return 0
        if (nums.size == 1) return if (nums[0] == k) 1 else 0

        var count = 0
        var total = 0
        val iterativeSums = mutableMapOf<Int, Int>().apply {
            this[0] = 1
        }
        
        nums.forEach {
            total += it
            count += iterativeSums.getOrDefault(total - k, 0)
            iterativeSums[total] = iterativeSums.getOrDefault(total, 0) + 1
        }

        return count
    }

}

fun main() {
    val solution = Solution()
    val output = solution.subarraySum(intArrayOf(1, 1, 1), 2)

    println("Expected: 2")
    println("Actual  : $output")
}
