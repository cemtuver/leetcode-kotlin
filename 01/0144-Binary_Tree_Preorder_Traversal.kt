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

    private val nodeList = mutableListOf<Int>()

    private fun traverse(node: TreeNode) {
        nodeList.add(node.`val`)
        node.left?.let { traverse(it) }        
        node.right?.let { traverse(it) }
    }

    fun preorderTraversal(root: TreeNode?): List<Int> {
        if (root != null) {
            traverse(root)
        }

        return nodeList
    }

}