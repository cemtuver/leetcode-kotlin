class Solution {

    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        var distances = IntArray(n) { Int.MAX_VALUE }
        distances[src] = 0

        repeat(k + 1) {
            val newDistances = distances.copyOf()

            flights.forEach { flight ->
                val from = flight[0]
                val to = flight[1]
                val cost = flight[2]

                if (distances[from] != Int.MAX_VALUE) {
                    newDistances[to] = minOf(newDistances[to], distances[from] + cost)
                }
            }

            distances = newDistances
        }

        return when {
            distances[dst] == Int.MAX_VALUE -> -1
            else -> distances[dst]
        }
    }

}