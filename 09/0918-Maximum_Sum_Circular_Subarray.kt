class Solution {

    fun maxSubarraySumCircular(nums: IntArray): Int {
        var sum = 0
        var maxSum = nums[0]
        var minSum = nums[0]
        var currentMax = 0
        var currentMin = 0

        nums.forEach { num ->
            sum += num
            currentMax = maxOf(currentMax, 0) + num
            currentMin = minOf(currentMin, 0) + num
            maxSum = maxOf(maxSum, currentMax)
            minSum = minOf(minSum, currentMin)
        }

        return when {
            minSum == sum -> maxSum
            else -> maxOf(maxSum, sum - minSum)
        }
    }

}