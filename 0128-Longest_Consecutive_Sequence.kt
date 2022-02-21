class Solution {

    fun longestConsecutive(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        
        var longest = 0
        val countMap = mutableMapOf<Int, Int>()
        
        nums.forEach { num ->
            if (countMap.contains(num)) return@forEach
            val leftEndDistance = countMap[num - 1] ?: 0
            val rightEndDistance = countMap[num + 1] ?: 0
            val current = 1 + leftEndDistance + rightEndDistance

            countMap[num] = current
            countMap[num - leftEndDistance] = current
            countMap[num + rightEndDistance] = current

            longest = maxOf(longest, current)
            println(countMap.toString())
        }
        
        return longest
    }

}

fun main() {
    val solution = Solution()
    val output = solution.longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2))

    println("Expected: 4")
    println("Actual  : $output")
}
