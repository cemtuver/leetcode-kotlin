class Solution {

    private var maxPath = 1

    private fun findPath(current: Int, children: Array<Set<Int>>, s: String): Int {
        if (children[current].size == 0) return 1

        var maxChildDepth1 = 0
        var maxChildDepth2 = 0

        children[current].forEach { child ->
            val childDepth = findPath(child, children, s)

            if (s[current] != s[child]) {
                when {
                    childDepth > maxChildDepth1 -> {
                        maxChildDepth2 = maxChildDepth1
                        maxChildDepth1 = childDepth
                    }
                    childDepth > maxChildDepth2 -> {
                        maxChildDepth2 = childDepth
                    }
                }
            }
        }

        val depth = 1 + maxChildDepth1
        val path = depth + maxChildDepth2

        maxPath = maxOf(maxPath, path)

        return depth
    }

    fun longestPath(parent: IntArray, s: String): Int {
        val children = Array<Set<Int>>(parent.size) { mutableSetOf() }

        for (i in 1 until parent.size) {
            (children[parent[i]] as MutableSet<Int>).add(i)
        }

        findPath(0, children, s)

        return maxPath
    }

}