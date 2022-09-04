fun main() {
    val li1 = ListNode(1)
    val li2 = ListNode(1)
    val li3 = ListNode(2)
    val li4 = ListNode(1)
    li3.next = li4
    li2.next = li3
    li1.next = li2

  /*  val li21 = ListNode(1)
    val li22 = ListNode(3)
    val li23 = ListNode(4)
    li22.next = li23
    li21.next = li22*/
    val r = reverseLink1(li1)
    println("reverse -----")
    printLink(r)
    println("head -----")
    printLink(li1)
    println("isPalindrome ${isPalindrome(li1)}")

}

/**
 * solved through help of discussion 234. Palindrome Linked List
 * https://leetcode.com/problems/palindrome-linked-list/
 *
 * Complexity
 *   Time: O(n)
 *   Space: (1)
 */
fun isPalindrome(head: ListNode?): Boolean {
    if (head == null) return true

    if (head.next == null) return true

    var fast: ListNode? = head
    var slow: ListNode? = head
    while (fast?.next != null && fast.next?.next != null) {
        fast = fast.next?.next
        slow = slow?.next
    }
    printLink(slow)
    println("fast")
    printLink(fast)

    //now where slow is present , that is midpoint
    //cut the chain, you will have 2 linked list now
    var secondHead: ListNode? = slow?.next
    slow?.next = null
    println("before r second")
    printLink(secondHead)
    secondHead = reverseLink(secondHead)
    println("after r second")
    printLink(secondHead)
    var firstHead:ListNode? =  head
    println(" firstHead")
    printLink(firstHead)
    println()
    //why using secondHead for traversing
    //The provided linked List size could even or odd.
    //for even, when you will break the chain it will equally distribute
    //for odd, when you will break the chain, one extra node in first chain will be present
    // which will be last node, which you don't need to compare with any other node
    while (secondHead != null) {
        println("val >>${secondHead.`val`}")

        if (firstHead?.`val` != secondHead.`val`) return false
        firstHead  = firstHead.next
        secondHead = secondHead.next
    }
    return true
}

private fun printLink(head: ListNode?) {
    if (head == null) return

    println("${head.`val`} ->")

    printLink(head.next)
}

private fun reverseLink(head: ListNode?): ListNode? { //1 > 2 > 2 > 1
    if(head == null) return null

    if(head.next == null) return head

    var current: ListNode? = head
    var result: ListNode? = null
    while (current != null) {
        val temp = current
        current = current.next
        temp.next = result
        result = temp

        println("val ${result.`val`}")

    }

    return result

}

/**
 * Reverse link list using recursion
 */
private fun reverseLink1(curr: ListNode?, prev: ListNode? = null): ListNode? { //1 > 2 > 2 > 1
    if(curr == null) return prev

    val next = curr.next
    curr.next = prev
    return reverseLink1(next, curr)
}
