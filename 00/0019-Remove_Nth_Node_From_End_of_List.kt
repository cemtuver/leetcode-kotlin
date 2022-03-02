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

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {       
        if (head == null) return null
        
        var left: ListNode? = head
        var right: ListNode? = head
        
        (0 until n).forEach { right = right?.next }
        
        return when (right) {
            null -> head?.next
            else -> {
                while (right?.next != null) {
                    right = right?.next
                    left = left?.next
                }

                left?.next = left?.next?.next
                return head
            }
        }
    }

}
