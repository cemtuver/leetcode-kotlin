class Solution {
    
    fun findNumberOfLIS(nums: IntArray): Int {
        if (nums.size == 0) return 0
        
        val n = nums.size
        val sizes = IntArray(n) { 0 }
        val counts = IntArray(n) { 0 }
        
        sizes[0] = 1
        counts[0] = 1
        
        for (i in 1 until n) {
            for (j in 0 until i) {
                if (nums[i] > nums[j]) {
                    val size = sizes[j] + 1
                    
                    when {
                        size == sizes[i] -> counts[i] += counts[j]
                        size > sizes[i] -> {
                            sizes[i] = size
                            counts[i] = counts[j]
                        }
                    }
                }            
            }
            
            sizes[i] = maxOf(1, sizes[i])
            counts[i] = maxOf(1, counts[i])
        }
        
        var maxCount = 0
        val maxSize = sizes.maxOrNull() ?: 0
        //val maxSize = sizes.max()
        
        sizes.forEachIndexed { index, size ->
            if (size == maxSize) {
                maxCount += counts[index]
            } 
        }
        
        return maxCount
    }

}

fun main() {
    val solution = Solution()
    val output = solution.findNumberOfLIS(intArrayOf(1, 3, 5, 4, 7))

    println("Expected: 2")
    println("Actual  : $output")
}