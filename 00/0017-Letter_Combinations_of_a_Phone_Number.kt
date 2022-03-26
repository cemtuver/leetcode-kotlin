class Solution {
    
    private val keys = arrayOf(
        "", 
        "", "abc", "def",
        "ghi", "jkl", "mno",
        "pqrs", "tuv", "wxyz"
    )
    
    private val result = mutableListOf<String>()
    
    private fun solve(digits: String, currentIndex: Int, currentString: String) {
        if (currentIndex == digits.length) {
            result.add(currentString)
            return
        }
        
        keys[digits[currentIndex].toInt() - 48].forEach { letter ->
            solve(digits, currentIndex + 1, currentString + letter)
        }
    }
    
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()
        solve(digits, 0, "")
        
        return result
    }
    
}

fun main() {
    val solution = Solution()
    val output = solution.letterCombinations("23")

    println("Expected: [ad, ae, af, bd, be, bf, cd, ce, cf]")
    println("Actual  : $output")
}