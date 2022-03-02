class Solution {

    fun maximumWealth(accounts: Array<IntArray>): Int {
        var max = -1

        accounts.forEach { account ->
            max = maxOf(max, account.sum())
        }

        return max
        //return accounts.maxOf { it.sum() }
    }

}

fun main() {
    val solution = Solution()
    val input = arrayOf(intArrayOf(1, 2, 3), intArrayOf(3, 2, 1))
    val output = solution.maximumWealth(input)

    println("Expected: 6")
    println("Actual  : $output")
}