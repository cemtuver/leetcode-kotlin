class Solution {
    
    fun reverseString(s: CharArray): Unit {
        for (left in 0 until s.size / 2) {
            val right = s.size - 1 - left
            s[left] = s[right].also { s[right] = s[left] }
        }
    }
    
}

fun main() {
    val solution = Solution()
    val input = charArrayOf('h', 'e', 'l', 'l', 'o')
    solution.reverseString(input)

    println("Expected: [o, l, l, e, h]")
    println("Actual  : ${input.toList()}")
}