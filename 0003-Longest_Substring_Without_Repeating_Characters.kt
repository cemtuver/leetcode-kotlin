class Solution {

    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) return 0
        if (s.length == 1) return 1

        var longestSubstring = 0
        var left = 0
        var right = 0
        var occurenceSet = mutableSetOf<Char>()

        while (right < s.length) {
            val char = s[right]

            if (occurenceSet.contains(char)) {
                occurenceSet.remove(s[left])
                left++
            } else {
                occurenceSet.add(char)
                longestSubstring = maxOf(longestSubstring, occurenceSet.size)
                right++
            }
        }

        return longestSubstring
    }

}

fun main() {
    val solution = Solution()
    val input = "abcabcbb"
    val output = solution.lengthOfLongestSubstring(input)

    println("Expected: 3")
    println("Actual  : $output")
}