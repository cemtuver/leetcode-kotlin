class Solution {

    fun findPairs(nums: IntArray, k: Int): Int {
        var pairs = 0
        val map = mutableMapOf<Int, Int>()

        nums.forEach { num ->
            map[num] = map.getOrDefault(num, 0) + 1
        }

        if (k == 0) {
            map.forEach { _, count ->
                if (count > 1) {
                    pairs++
                }
            }
        } else {
            map.forEach { num, _ ->
                if (map.containsKey(num + k)) {
                    pairs++
                }
            }
        }

        return pairs
    }

}

fun main() {
    val solution = Solution()
    val output = solution.findPairs(intArrayOf(1, 2, 4, 4, 3, 3, 0, 9, 2, 3, 7), 3)

    println("Expected: 3")
    println("Actual  : $output")
}
