class Solution {

    fun swapPairs(head: ListNode?): ListNode? {
        if (head == null) return null
        if (head.next == null) return head

        var newHead = head.next
        var current = head
        var prev: ListNode? = null

        while (current != null) {
            val next = current.next

            current.next = next?.next
            
            if (next != null) {
                next.next = current
                prev?.next = next
            }

            prev = current
            current = current.next
        }

        return newHead
    }

}