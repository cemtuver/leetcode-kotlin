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
    fun oddEvenList(head: ListNode?): ListNode? {
        val oddHead = head
        val evenHead = head?.next
        
        var i = 1
        var current = head
        var oddCurrent: ListNode? = null
        var evenCurrent: ListNode? = null
        
        while (current != null) {
            when {
                i % 2 == 0 -> {
                    evenCurrent?.let { it.next = current }
                    evenCurrent = current
                } 
                else -> {
                    oddCurrent?.let { it.next = current }
                    oddCurrent = current
                }
            }

            current = current?.next
            i++
        }

        oddCurrent?.let { it.next = evenHead }
        evenCurrent?.let { it.next = null }

        return oddHead
    }
}
