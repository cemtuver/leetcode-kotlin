class Solution {

    fun addDigits(num: Int): Int {
        var result = num
        
        while (result >= 10) {
            result = (result % 10) + (result / 10)
        }
        
        return result
    }

}

fun main() {
    val solution = Solution()
    val output = solution.addDigits(38)

    println("Expected: 2")
    println("Actual  : $output")
}
