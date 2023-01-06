class Solution {

    fun maxIceCream(costs: IntArray, coins: Int): Int {
        var current = 0
        var coinsLeft = coins

        costs.sort()

        while (coinsLeft > 0 && current < costs.size && costs[current] <= coinsLeft) {
            coinsLeft -= costs[current]
            current++
        }

        return current   
    }

}