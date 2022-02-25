class Solution {

    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var maxArea = 0
        
        while (left < right) {
            maxArea = maxOf(
                maxArea,
                (right - left) * minOf(height[left], height[right])
            )
            
            when {
                height[left] <= height[right] -> left++
                else -> right--
            }        
        }
        
        return maxArea
    }

}

fun main() {
    val solution = Solution()
    val output = solution.maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7))

    println("Expected: 49")
    println("Actual  : $output")
}
