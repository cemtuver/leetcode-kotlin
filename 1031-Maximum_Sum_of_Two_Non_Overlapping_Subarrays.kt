class Solution {

    fun maxSumTwoNoOverlap(nums: IntArray, firstLen: Int, secondLen: Int): Int {
        val n = nums.size - 1
        val firstMax = IntArray(nums.size) { -1 }
        val secondMax = IntArray(nums.size) { -1 }
        
        firstMax[0] = 0
        for (i in 0 until firstLen) { firstMax[0] += nums[i] }
        for (i in 1..n - firstLen + 1) { 
            firstMax[i] = firstMax[i - 1] - nums[i - 1] + nums[i + firstLen - 1]
        }

        secondMax[0] = 0
        for (i in 0 until secondLen) { secondMax[0] += nums[i] }
        for (i in 1..n - secondLen + 1) { 
            secondMax[i] = secondMax[i - 1] - nums[i - 1] + nums[i + secondLen - 1]
        }
        
        var max = -1
        
        for (i in 0..n) {
            val first = firstMax[i]
            var second = -1
            
            for (j in (i + firstLen)..n) {
                second = maxOf(second, secondMax[j])
            }
            
            for (j in 0..(i - secondLen)) {
                second = maxOf(second, secondMax[j])
            }
            
            max = maxOf(max, first + second)
        }
        
        return max
    }

}

fun main() {
    val solution = Solution()
    val output = solution.maxSumTwoNoOverlap(intArrayOf(0, 6, 5, 2, 2, 5, 1, 9, 4), 1, 2)

    println("Expected: 20")
    println("Actual  : $output")
}