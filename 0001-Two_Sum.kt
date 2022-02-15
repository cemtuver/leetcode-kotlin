class Solution {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        
        nums.forEachIndexed { index, num ->
            val other = target - num
            
            if (map.containsKey(other)) {
                return intArrayOf(map.getValue(other), index)
            }
            
            map[num] = index
        }
        
        return intArrayOf()
    }

}

fun main() {
    val solution = Solution()
    val output = solution.twoSum(intArrayOf(2, 7, 11, 15), 9)

    println("Expected: [0, 1]")
    println("Actual  : ${output.toList()}")
}