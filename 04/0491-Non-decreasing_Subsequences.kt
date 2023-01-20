class Solution {

    private fun findSubsequences(current: Int, currentSubsequence: MutableList<Int>, subsequences: MutableSet<List<Int>>, nums: IntArray) {
        if (currentSubsequence.size > 1) {
            subsequences.add(currentSubsequence.toList())
        }

        for (i in current until nums.size) {
            if (!currentSubsequence.isEmpty() && nums[i] < currentSubsequence.last()) {
                continue
            }

            currentSubsequence.add(nums[i])
            findSubsequences(i + 1, currentSubsequence, subsequences, nums)
            currentSubsequence.removeAt(currentSubsequence.size - 1)
        }
    }

    fun findSubsequences(nums: IntArray): List<List<Int>> {
        val subsequences = mutableSetOf<List<Int>>()
        findSubsequences(0, mutableListOf(), subsequences, nums)

        return subsequences.toList()
    }

}