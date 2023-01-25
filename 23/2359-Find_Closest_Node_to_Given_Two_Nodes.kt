class Solution {

    private fun findDistances(node: Int, edges: IntArray): IntArray {
        var distance = 1
        var current = node
        var distances = IntArray(edges.size) { -1 }
        distances[node] = 0

        while (edges[current] != -1 && distances[edges[current]] == -1) {
            current = edges[current]
            distances[current] = distance
            distance++
        }

        return distances
    }

    fun closestMeetingNode(edges: IntArray, node1: Int, node2: Int): Int {
        val distances1 = findDistances(node1, edges)
        val distances2 = findDistances(node2, edges)
        var minDistance = Int.MAX_VALUE
        var minDistanceNode = -1

        for (i in 0 until edges.size) {
            if (distances1[i] == -1 || distances2[i] == -1) continue
            val maxDistance = maxOf(distances1[i], distances2[i])

            if (maxDistance < minDistance) {
                minDistance = maxDistance
                minDistanceNode = i
            }
        }

        return minDistanceNode
    }

}