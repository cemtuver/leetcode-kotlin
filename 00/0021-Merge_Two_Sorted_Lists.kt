/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    
    private fun ListNode?.requireVal(): Int {
        return this?.`val` ?: Int.MAX_VALUE
    }
    
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) return list2
        if (list2 == null) return list1
        
        var current = ListNode(0)
        val head = current
        var left: ListNode? = list1
        var right: ListNode? = list2
        
        while (true) {
            when {
                left.requireVal() < right.requireVal() -> {
                    current.`val` = left.requireVal()
                    left = left?.next
                }
                else -> {
                    current.`val` = right.requireVal()
                    right = right?.next
                }
            }
            
            if (left == null && right == null) {
                break
            }
            
            current.next = ListNode(0).also { current = it }   
        }
        
        return head
    }
    
}