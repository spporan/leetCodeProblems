import java.util.LinkedList

fun main() {
    val myStack = MyStack()
    myStack.push(1)
    myStack.push(3)
    myStack.push(5)
    myStack.push(6)
}
/**
 * Implement stack using double queue
 * https://leetcode.com/problems/implement-stack-using-queues/
 *
 * Complexity:
 *  here,
 *   n  = size of queue
 *   time: O(n)
 *   space: O(n)
 */
class MyStack() {
    var queue1 = LinkedList<Int>()
    var queue2 = LinkedList<Int>()

    fun push(x: Int) {
        queue2.add(x)
        while (queue1.isNotEmpty()) {
            queue2.add(queue1.remove())
        }
        val  temp = queue1
        queue1 = queue2
        queue2 = temp
    }

    fun pop(): Int {
        if (empty()) return Int.MIN_VALUE

        return queue1.pop()
    }

    fun top(): Int {
        if (empty()) return Int.MIN_VALUE
        return queue1.peek()
    }

    fun empty(): Boolean {
        return queue1.isEmpty()
    }

}

/**
 * Implement stack using single queue
 * https://leetcode.com/problems/implement-stack-using-queues/
 *
 * Complexity:
 *  here,
 *   n  = size of queue
 *   time: O(n)
 *   space: O(n)
 */
class MyStack1() {
    var queue1 = LinkedList<Int>()


    fun push(x: Int) {
        queue1.add(x)
        for (i in 0 until queue1.size -1) {
            queue1.add(queue1.pop())
        }
    }

    fun pop(): Int {
        if (empty()) return Int.MIN_VALUE

        return queue1.pop()
    }

    fun top(): Int {
        if (empty()) return Int.MIN_VALUE
        return queue1.peek()
    }

    fun empty(): Boolean {
        return queue1.isEmpty()
    }

}