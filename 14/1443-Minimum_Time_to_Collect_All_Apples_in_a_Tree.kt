class Solution {

    private fun dfs(
        n: Int, 
        neighbours: Array<MutableList<Int>>, 
        hasApple: List<Boolean>, 
        visited: MutableSet<Int>
    ): Int {
        if (visited.contains(n)) return 0
        var time = 0

        visited.add(n)
        neighbours[n].forEach { neighbour ->
            time += dfs(neighbour, neighbours, hasApple, visited)
        }

        if (n != 0 && (time > 0 || hasApple[n])) {
            time += 2
        }

        return time
    }

    fun minTime(n: Int, edges: Array<IntArray>, hasApple: List<Boolean>): Int {
        if (hasApple.none { it }) return 0

        val neighbours = Array(n) { mutableListOf<Int>() }
        val visited = mutableSetOf<Int>()

        edges.forEach { edge -> 
            neighbours[edge[0]].add(edge[1])
            neighbours[edge[1]].add(edge[0])
        }

        return dfs(0, neighbours, hasApple, visited)
    }

}