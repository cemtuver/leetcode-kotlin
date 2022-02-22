class Solution {

    fun longestPalindrome(s: String): String {
        val n = s.length
        val palindromeMatrix = Array(n) { BooleanArray(n) }
        var start = 0
        var end = 0
        
        for (i in 0 until n) {
            palindromeMatrix[i][i] = true 
        }
        
        for (i in 0 until n - 1) {
            if (s[i] == s[i + 1]) {
                palindromeMatrix[i][i + 1] = true 
                start = i;
                end = i + 1;
            }
        }


        for (k in 3..n) {
            for (i in 0..(n - k)) {
                val j = k + i - 1

                if (palindromeMatrix[i + 1][j - 1] && s[i] == s[j]) {
                    palindromeMatrix[i][j] = true

                    if (end - start < j - i) {
                        start = i
                        end = j
                    }
                }
            }
        }
        
        return s.substring(start, end + 1)
    }

}

fun main() {
    val solution = Solution()
    val output = solution.longestPalindrome("babad")

    println("Expected: bab")
    println("Actual  : $output")
}