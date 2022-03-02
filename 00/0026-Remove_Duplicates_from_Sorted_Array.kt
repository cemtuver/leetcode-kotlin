class Solution {

    fun removeDuplicates(nums: IntArray): Int {
        var previous = -101
        var resultIndex = 0

        nums.forEach { num ->
            if (previous != num) {
                nums[resultIndex] = num
                resultIndex++
            }

            previous = num
        }

        return resultIndex
    }

}

fun main() {
    val solution = Solution()
    val input = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
    val output = solution.removeDuplicates(input)

    println("Expected: 5, [0, 1, 2, 3, 4, _, _, _, _, _]")
    println("Actual  : $output, ${input.toList()}")
}