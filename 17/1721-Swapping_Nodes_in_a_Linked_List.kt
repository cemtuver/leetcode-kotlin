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
    
    fun swapNodes(head: ListNode?, k: Int): ListNode? {
        var left = head
        var right = head
        
        repeat(k - 1) { left = left?.next }
        
        var current = left
        
        while (current?.next != null) {
            current = current?.next
            right = right?.next 
        }
        
        right?.`val` = left?.`val`?.also {
            left?.`val` = right?.`val`
        }
        
        return head
    }
    
}