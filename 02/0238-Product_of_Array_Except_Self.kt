class Solution {
    
    fun productExceptSelf(nums: IntArray): IntArray {
        var current = 1
        val products = IntArray(nums.size) { _ -> 1 }
        
        for (i in 1 until nums.size) {
            products[i] = products[i - 1] * nums[i - 1]
        }
        
        for (i in nums.size - 1 downTo 0) {
            products[i] = products[i] * current
            current = current * nums[i]
        }
        
        return products
    }
    
}

fun main() {
    val solution = Solution()
    val output = solution.productExceptSelf(intArrayOf(1, 2, 3, 4))

    println("Expected: [24, 12, 8, 6]")
    println("Actual  : ${output.toList()}")
}
