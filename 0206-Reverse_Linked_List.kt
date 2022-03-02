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
    
    fun reverseList(head: ListNode?): ListNode? {
        var previous = head
        var current = head?.next
        
        previous?.next = null
        
        while (current != null) {
            var next = current?.next
            
            current?.next = previous
            previous = current
            current = next
        }
        
        return previous
    }
    
}