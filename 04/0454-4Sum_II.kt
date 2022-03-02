class Solution {
    
    fun fourSumCount(nums1: IntArray, nums2: IntArray, nums3: IntArray, nums4: IntArray): Int {
        var sumCount = 0
        val n = nums1.size
        val nums12Map = mutableMapOf<Int, Int>()
        
        for (i in 0 until n) {
            for (j in 0 until n) {
                val sum = nums1[i] + nums2[j]
                nums12Map[sum] = nums12Map.getOrDefault(sum, 0) + 1
            }
        }
        
        for (i in 0 until n) {
            for (j in 0 until n) {
                val sum = nums3[i] + nums4[j]
                sumCount += nums12Map.getOrDefault(-sum, 0)
            }
        }

        return sumCount
    }
    
}

fun main() {
    val solution = Solution()
    val output = solution.fourSumCount(intArrayOf(1, 2), intArrayOf(-2, -1), intArrayOf(-1, 2), intArrayOf(0, 2))

    println("Expected: 2")
    println("Actual  : $output")
}
