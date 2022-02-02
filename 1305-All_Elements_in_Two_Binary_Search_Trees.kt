class Solution {
    
    // Traverse + Sort

    fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {
        val list = mutableListOf<Int>()

        root1?.let { toList(it, list) }
        root2?.let { toList(it, list) }

        return list.sorted()
    }

    private fun toList(node: TreeNode, list: MutableList<Int>) {
        list.add(node.`val`)
        node.left?.let { toList(it, list) }
        node.right?.let { toList(it, list) }
    }
    
}

class Solution {

    // Traverse + Merge
    
    fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {
        val list = mutableListOf<Int>()
        val list1 = mutableListOf<Int>()
        val list2 = mutableListOf<Int>()        

        toList(root1, list1)
        toList(root2, list2)
        
        var index1 = 0
        var index2 = 0

        while (index1 < list1.size || index2 < list2.size) {
            val current1 = list1.getOrElse(index1) { Int.MAX_VALUE }
            val current2 = list2.getOrElse(index2) { Int.MAX_VALUE }

            if (current1 < current2) {
                list.add(current1)
                index1++
            } else {
                list.add(current2)
                index2++
            }
        }

        return list
    }

    private fun toList(root: TreeNode?, list: MutableList<Int>) {
        if (root == null) return
        
        toList(root.left, list)
        list.add(root.`val`)
        toList(root.right, list)
    }

}