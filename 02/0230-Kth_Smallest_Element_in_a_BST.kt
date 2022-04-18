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
class Solution {
    
    private var current = 0
    private var result = 0

    fun dfsCount(node: TreeNode, k: Int) {
        if (current > k) return
        
        node.left?.let { dfsCount(it, k) }
        
        if (++current == k) {
            result = node.`val`
            return
        }
        
        node.right?.let { dfsCount(it, k) }
    }
    
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        dfsCount(root!!, k)
        return result
    }

}
