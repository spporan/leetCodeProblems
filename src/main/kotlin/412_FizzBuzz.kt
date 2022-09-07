fun main() {
    println("Fizz buzz${fizzBuzz(15)}")
}

/**
 * Solved 412. Fizz Buzz
 * https://leetcode.com/problems/fizz-buzz/
 *
 * Complexity
 *  Time: O(n)
 *  Space: O(n)
 *
 */
fun fizzBuzz(n: Int): List<String> {
    val list = mutableListOf<String>()
    for (i in 1 .. n) {
        if (i % 3 == 0 && i % 5 == 0) {
            list.add("FizzBuzz")
        }
        else if (i % 3 == 0) {
            list.add("Fizz")
        }
        else if (i % 5 == 0) {
            list.add("Buzz")
        } else {
            list.add("$i")
        }
    }
    return list
}