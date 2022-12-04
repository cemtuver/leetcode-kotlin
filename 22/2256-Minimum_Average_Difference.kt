class Solution {

    fun minimumAverageDifference(nums: IntArray): Int {
        if (nums.size == 1) return 0

        var minIndex = -1
        var minAvarageDiff = Long.MAX_VALUE
        var left = 0L
        var right = 0L
        nums.forEach { right += it }

        for (i in 0..nums.size - 1) {
            left += nums[i]
            right -= nums[i]
            
            val leftDiff = left / (i + 1).toLong()
            val rightDiff = when {
                right == 0L -> 0L
                else -> right / (nums.size - i - 1).toLong()
            }

            val avarageDiff = Math.abs(leftDiff - rightDiff)

            if (avarageDiff < minAvarageDiff) {
                minAvarageDiff = avarageDiff
                minIndex = i
            }
        }

        return minIndex
    }

}