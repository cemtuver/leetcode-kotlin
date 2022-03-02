class Solution {
    
    private fun produceParenthesis(
        result: MutableList<String>,
        current: String,
        openCount: Int,
        closeCount: Int,
        n: Int
    ) {
        if (openCount == n && closeCount == n) {
            result.add(current)
            return
        }
        
        if (openCount < n) {
            produceParenthesis(result, current + "(", openCount + 1, closeCount, n)
        }
        
        if (closeCount < openCount) {
            produceParenthesis(result, current + ")", openCount, closeCount + 1, n)
        }
    }
    
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()
        produceParenthesis(result, "", 0, 0, n)
        
        return result
    }
    
}

fun main() {
    val solution = Solution()
    val output = solution.generateParenthesis(3)

    println("Expected: [((())), (()()), (())(), ()(()), ()()()]")
    println("Actual  : $output")
}