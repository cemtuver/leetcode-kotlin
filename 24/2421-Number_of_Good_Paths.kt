class Solution {

    fun numberOfGoodPaths(vals: IntArray, edges: Array<IntArray>): Int {
        if (edges.size == 0) return vals.size

        var numberOfGoodPaths = vals.size
        val roots = IntArray(vals.size) { it }
        val counts = Array(vals.size) { mutableMapOf(vals[it] to 1) }
        val sortedEdges = edges.sortedBy { maxOf(vals[it[0]], vals[it[1]]) }

        sortedEdges.forEach { (from, to) ->
            var rootOfFrom = from
            var rootOfTo = to
            val value = maxOf(vals[from], vals[to])

            while (rootOfFrom != roots[rootOfFrom]) rootOfFrom = roots[rootOfFrom]
            while (rootOfTo != roots[rootOfTo]) rootOfTo = roots[rootOfTo]

            roots[from] = rootOfFrom
            roots[to] = rootOfTo

            if (rootOfFrom != rootOfTo) {
                val countInFrom = counts[rootOfFrom][value] ?: 0
                val countInTo = counts[rootOfTo][value] ?: 0

                roots[rootOfFrom] = rootOfTo
                counts[rootOfTo][value] = countInFrom + countInTo
                numberOfGoodPaths += countInFrom * countInTo
            }
        }

        return numberOfGoodPaths
    }

}
