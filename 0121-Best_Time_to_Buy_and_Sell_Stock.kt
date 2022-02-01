class Solution {

    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0
        var buyPrice = prices[0]

        prices.forEach { price ->
            buyPrice = minOf(buyPrice, price)
            maxProfit = maxOf(maxProfit, price - buyPrice)
        }

        return maxProfit
    }

}

fun main() {
    val solution = Solution()
    val input = intArrayOf(7, 1, 5, 3, 6, 4)
    val output = solution.maxProfit(input)

    println("Expected: 5")
    println("Actual  : $output")
}