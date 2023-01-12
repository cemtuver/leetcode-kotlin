class Solution {

    fun dfs(
        current: Int, 
        labels: String, 
        neighbours: Array<List<Int>>,
        counts: Array<IntArray>,
        visited: BooleanArray
    ) {
        val count = counts[current]
        val label = labels[current]

        visited[current] = true
        neighbours[current].forEach { neighbour ->
            if (!visited[neighbour]) {
                dfs(neighbour, labels, neighbours, counts, visited)
                counts[neighbour].forEachIndexed { i, neighbourCount ->
                    count[i] += neighbourCount
                }
            }
        }

        count[label.toInt() - 'a'.toInt()] += 1
    }

    fun countSubTrees(n: Int, edges: Array<IntArray>, labels: String): IntArray {
        val result = IntArray(n) { 0 }
        val counts = Array<IntArray>(n) { IntArray(26) { 0 } }
        val neighbours = Array<List<Int>>(n) { mutableListOf<Int>() }
        val visited = BooleanArray(n) { false }

        edges.forEach { edge -> 
            (neighbours[edge[0]] as MutableList<Int>).add(edge[1])
            (neighbours[edge[1]] as MutableList<Int>).add(edge[0])
        }

        dfs(0, labels, neighbours, counts, visited)

        labels.forEachIndexed { i, label ->
            result[i] = counts[i][label.toInt() - 'a'.toInt()]
        }

        return result
    }

}