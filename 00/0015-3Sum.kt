class Solution {
    
    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) return emptyList()
      
        var current = 0
        var left = 1
        var right = nums.size - 1
        val sorted = nums.sorted()
        val result = mutableSetOf<List<Int>>() 
        
        while (current < sorted.size - 2) {
            val target = -sorted[current]
            
            while (left < right) {
                val sum = sorted[left] + sorted[right]
                
                when {
                    sum < target -> left++
                    sum > target -> right--
                    else -> {
                        result.add(listOf(sorted[current], sorted[left], sorted[right]))
                        left++
                        right--
                    }
                }
            }
            
            current++
            left = current + 1
            right = nums.size - 1
        }
        
        return result.toList()
    }
    
}

fun main() {
    val solution = Solution()
    val output = solution.threeSum(intArrayOf(-1, 0, 1, 2, -1, -4))

    println("Expected: [[-1, -1, 2], [-1, 0, 1]]")
    println("Actual  : $output")
}