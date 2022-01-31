class Solution {

    fun isValid(s: String): Boolean {
        val stack = mutableListOf<Char>()
        val parenthesesMap = mapOf(
            '(' to ')',
            '{' to '}',
            '[' to ']'
        )

        s.forEach { char ->
            if (parenthesesMap.containsKey(char)) {
                stack.add(parenthesesMap.getValue(char))
            } else if (stack.isEmpty() || stack.removeAt(stack.size - 1) != char) {
                return false
            }
        }
        
        return stack.isEmpty()
    }

}

fun main() {
    val solution = Solution()
    val input = "{()[]{}}"
    val output = solution.isValid(input)

    println("Expected: true")
    println("Actual  : $output")
}