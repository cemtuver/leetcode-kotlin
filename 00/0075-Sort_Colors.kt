class Solution {

    fun sortColors(nums: IntArray): Unit {
        var redIndex = 0
        var blueIndex = nums.size - 1
        var current = 0
        
        while (current <= blueIndex) {
            when (nums[current]) {
                0 -> {
                    nums[current] = nums[redIndex]
                    nums[redIndex] = 0
                    redIndex++
                    current++
                }
                1 -> {
                    current++
                }
                2 -> {
                    nums[current] = nums[blueIndex]
                    nums[blueIndex] = 2
                    blueIndex--
                }
            }
        }
        
    }

}

fun main() {
    val solution = Solution()
    val input = intArrayOf(2, 0, 2, 1, 1, 0)
    solution.sortColors(input)

    println("Expected: [0, 0, 1, 1, 2, 2]")
    println("Actual  : ${input.toList()}")
}