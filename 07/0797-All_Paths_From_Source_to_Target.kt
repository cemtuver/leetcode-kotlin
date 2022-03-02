class Solution {

    private val pathList = mutableListOf<List<Int>>()

    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        findPaths(graph, 0, graph.size - 1, emptyList())
        return pathList
    }

    private fun findPaths(graph: Array<IntArray>, from: Int, to: Int, path: List<Int>) {
        if (from == to) {
            pathList.add(path + from)
            return
        }

        graph[from].forEach { child ->
            findPaths(graph, child, to, path + from)
        }
    }

}

fun main() {
    val solution = Solution()
    val input = arrayOf(intArrayOf(1, 2), intArrayOf(3), intArrayOf(3), intArrayOf())
    val output = solution.allPathsSourceTarget(input)

    println("Expected: [[0, 1, 3], [0, 2, 3]]")
    println("Actual  : $output")
}
