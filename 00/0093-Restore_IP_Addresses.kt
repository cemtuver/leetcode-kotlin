class Solution {

    private fun dfs(current: Int, groups: MutableList<Int>, values: IntArray, ipAddresses: MutableList<String>) {
        if (groups.size == 4) {
            if (current == values.size) {
                ipAddresses.add(groups.joinToString("."))
            }
            return
        }

        var group = 0

        for (i in current until values.size) {
            group = group * 10 + values[i]
            
            if (group > 255) break

            groups.add(group)
            dfs(i + 1, groups, values, ipAddresses)
            groups.removeAt(groups.size - 1)

            if (group == 0) break
        }
    }

    fun restoreIpAddresses(s: String): List<String> {
        val values = IntArray(s.length) { s[it].toInt() - 48 }
        val ipAddresses = mutableListOf<String>()

        dfs(0, mutableListOf(), values, ipAddresses)

        return ipAddresses
    }

}