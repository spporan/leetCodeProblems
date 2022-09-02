import java.util.Stack

fun main() {

}

/**
 * Solved 232 problem Implement queue using stacks
 *https://leetcode.com/problems/implement-queue-using-stacks/
 * Complexity
 *  time: O(n + n) = O(2n) = O(n)
 *  space: O(2n) = O(n)
 */
class MyQueue() {
    var stack1:  Stack<Int> = Stack()

    var stack2:  Stack<Int> = Stack()


    fun push(x: Int) {

        while (stack1.isNotEmpty()) {
            stack2.push(stack1.pop())
        }

        stack1.push(x)
       while (stack2.isNotEmpty()) {
           stack1.push(stack2.pop())
       }
    }

    fun pop(): Int {
        return stack1.pop()
    }

    fun peek(): Int {
        return stack1.peek()
    }

    fun empty(): Boolean {
        return stack1.empty()
    }

}
