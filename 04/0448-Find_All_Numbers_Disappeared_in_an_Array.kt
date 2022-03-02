class Solution {
    
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val set = (1..nums.size).toMutableSet()
        
        nums.forEach { num ->
            set.remove(num) 
        }
        
        return set.toList()
    }
    
}

fun main() {
    val solution = Solution()
    val output = solution.findDisappearedNumbers(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1))

    println("Expected: [5, 6]")
    println("Actual  : $output")
}