class Solution {

    fun findAnagrams(s: String, p: String): List<Int> {
        if (s.length < p.length) return emptyList()

        val resultList = mutableListOf<Int>()
        var left = 0
        var right = p.length - 1
        val pCharCount = countChars(p)
        val currentCharCount = countChars(s.take(p.length))
            .toMutableMap()

        while (true) {
            if (currentCharCount == pCharCount) {
                resultList.add(left)
            }

            right++
            if (right >= s.length) break

            if (s[left] != s[right]) {
                val leftCount = currentCharCount.getValue(s[left])
                val rightCount = currentCharCount.getOrElse(s[right]) { 0 }

                when (leftCount) {
                    1 -> currentCharCount.remove(s[left])
                    else -> currentCharCount[s[left]] = leftCount - 1
                }

                currentCharCount[s[right]] = rightCount + 1
            }

            left++
        }

        return resultList
    }

    fun countChars(string: String): Map<Char, Int> {
        return string.groupingBy { it }.eachCount()
    }

}

fun main() {
    val solution = Solution()
    val s = "cbaebabacd"
    val p = "abc"
    val output = solution.findAnagrams(s, p)

    println("Expected: [0, 6]")
    println("Actual  : $output")
}
