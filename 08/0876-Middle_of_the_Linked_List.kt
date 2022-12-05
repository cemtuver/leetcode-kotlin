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
    fun middleNode(head: ListNode?): ListNode? {
        if (head?.next == null) return head 

        var numberOfItems = 1
        var current = head
        while (current != null) {
            current = current?.next
            numberOfItems++
        }

        var mid = Math.ceil(numberOfItems / 2.0).toInt()
        current = head
        while (mid > 1) {
            current = current?.next
            mid--
        }

        return current
    }
}