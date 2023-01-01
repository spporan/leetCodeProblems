import java.util.Stack

fun main() {
    println("is valid ${isValid("()[]{}")}")
}

fun isValid(s: String): Boolean {
    val stack: Stack<Char> = Stack()

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