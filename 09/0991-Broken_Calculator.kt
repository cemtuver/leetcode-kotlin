class Solution {
    
    fun brokenCalc(startValue: Int, target: Int): Int {
        if (startValue == target) return 0
        if (startValue > target) return startValue - target
        
        return 1 + when {
            target.and(1) == 0 -> brokenCalc(startValue, target / 2)
            else -> brokenCalc(startValue, target + 1)
        }
    }

}

fun main() {
    val solution = Solution()
    val output = solution.brokenCalc(5, 8)

    println("Expected: 2")
    println("Actual  : $output")
}