class Solution {

    fun permuteUnique(nums: IntArray): List<List<Int>> {
        return permuteUnique(nums.toList())
    }

    fun permuteUnique(nums: List<Int>): MutableList<MutableList<Int>> {
        if (nums.size == 1) return mutableListOf(mutableListOf(nums[0]))
        val list = mutableListOf<MutableList<Int>>()
        val visited = mutableSetOf<Int>()

        nums.forEach { num ->
            if (visited.contains(num)) return@forEach
            val subNums = nums.toMutableList().also { it.remove(num) }
            val subPermutes = permuteUnique(subNums)

            subPermutes.forEach { subPermute ->
                subPermute.add(0, num)
                list.add(subPermute)
            }

            visited.add(num)
        }

        return list
    }

}
 
fun main() {
    val solution = Solution()
    val nums = intArrayOf(1, 1, 2)
    val output = solution.permuteUnique(nums)

    println("Expected: [[1, 1, 2], [1, 2, 1], [2, 1, 1]]")
    println("Actual  : $output")
}