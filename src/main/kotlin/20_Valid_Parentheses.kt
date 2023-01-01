import java.util.Stack

fun main() {
    println("is valid ${isValid("()[{}")}")
}

fun isValid(s: String): Boolean {
    val stack: MyCustomStack<Char> = MyCustomStack()

    for (char in s.toCharArray()) {
        if(char == ')' && stack.isNotEmpty() && stack.peek() == '(') {
            stack.pop()
        }
        else if (char == '}' && stack.isNotEmpty() && stack.peek() == '{' ) {
            stack.pop()
        }
        else if (char == ']' && stack.isNotEmpty() && stack.peek() == '[' ) {
            stack.pop()
        } else {
            stack.push(char)
        }
    }
    return stack.isEmpty()
}

internal class MyCustomStack<T>() {
    private val stack: MutableList<T> = mutableListOf()

    fun clear() {
        stack.clear()
    }

    fun isEmpty() = stack.isEmpty()

    fun isNotEmpty() = stack.isNotEmpty()

    fun pop() {
        if (stack.isEmpty()) throw Exception("Empty stack")
        stack.removeAt(stack.size - 1)
    }

    fun push(value: T) {
        stack.add(value)
    }

    fun peek(): T {
        if (stack.isEmpty()) throw Exception("Empty stack")
        return stack[stack.size - 1]
    }
}