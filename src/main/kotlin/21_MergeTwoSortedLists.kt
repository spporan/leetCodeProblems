/**
 * @link  https://leetcode.com/problems/interview_prep.merge-two-sorted-lists/
 * problem is: 21. Merge Two Sorted Lists
 */

fun main() {
    val li1 = ListNode(1)
    val li2 = ListNode(2)
    val li3 = ListNode(4)
    li2.next = li3
    li1.next = li2

    val li21 = ListNode(1)
    val li22 = ListNode(3)
    val li23 = ListNode(4)
    li22.next = li23
    li21.next = li22

    // test for recursion solution
    //val result = mergeTwoLists(li1, li21)
   // printFun(result)
    println("#####################################\n\n")
    // test for iterative solution
    val result2 = mergeTwoListsIterate(li1, li21)
    printFun(result2)
}

// Definition for singly-linked list.
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

/**
 * This solution using recursion
 */
fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 != null && list2 == null) {
        list1.next = mergeTwoLists(list1.next, null)
        return list1
    }
    else if (list1 == null && list2 != null) {
        list2.next = mergeTwoLists(null, list2.next)
        return list2
    }

    if (list1 == null || list2 == null) return null

    return if (list1.`val` < list2.`val`) {
        list1.next = mergeTwoLists(list1.next, list2)
        list1
    }  else {
        list2.next  = mergeTwoLists(list1, list2.next)
        list2
    }

}

/**
 * This solution using iterator
 */
fun mergeTwoListsIterate(list1: ListNode?, list2: ListNode?): ListNode? {
    var current1 = list1
    var current2 = list2
    val head = ListNode(0)
    var result: ListNode? = head
    while (current1 != null && current2 != null) {
        if (current1.`val` <= current2.`val`) {
            result?.next = current1
            current1 = current1.next
            result = result?.next
        } else {
            result?.next = current2
            current2 = current2.next
            result = result?.next
        }
    }
    if (current1 != null) result?.next = current1 else result?.next = current2
    return head.next
}

fun printFun(list1: ListNode?) {
    println("node sorted and marge value<>: $list1")

    var current = list1
    while (current != null) {
        println("node sorted and marge value: ${current.`val`}")
        current = current.next
    }
}