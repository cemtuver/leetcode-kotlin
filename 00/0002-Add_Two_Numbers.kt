class Solution {

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null || l2 == null) return null
        
        var carry = 0
        var current1: ListNode? = l1
        var current2: ListNode? = l2
        var currentR = ListNode(-1)
        var prevR: ListNode? = null
        var rootR = currentR
        
        while (current1 != null || current2 != null || carry > 0) {
            val sum = (current1?.`val` ?: 0) + (current2?.`val` ?: 0) + carry
            val next = ListNode(-1)
            
            current1 = current1?.next
            current2 = current2?.next
            currentR.`val` = sum % 10
            currentR.next = next
            carry = if (sum >= 10) 1 else 0

            prevR = currentR
            currentR = next
        }
        
        if (currentR?.`val` == -1) {
            prevR?.next = null
        }
        
        return rootR
    }

}