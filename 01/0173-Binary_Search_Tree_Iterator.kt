/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class BSTIterator(root: TreeNode?) {

    private val nodes = ArrayDeque<TreeNode>()
    
    init {
        var current = root
        
        while (current != null) {
            nodes.addLast(current)
            current = current?.left
        }
    }
    
    fun next(): Int {
        val node = nodes.removeLast() ?: return -1
        var current = node.right
        
        while (current != null) {
            nodes.addLast(current)
            current = current?.left
        }
        
        return node.`val`
    }

    fun hasNext(): Boolean {
        return !nodes.isEmpty()
    }

}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */