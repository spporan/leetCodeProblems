import kotlin.math.pow

fun main() {
    println("isPowerOfTwo ${isPowerOfTwo2(3)}")
}

/**
 * Solved 202 power of two
 * https://leetcode.com/problems/power-of-two/submissions/
 * Complexity
 *  Time: O(1)
 *  Space: O(1)
 *
 *
 */
fun isPowerOfTwo(n: Int): Boolean {
    for(i in 0 .. 31) {

        val res = 2.0.pow(i)
        println("$i res $res")

        if (res == n.toDouble())  return true

    }
    return false
}

/**
 * for example, m = 6 = 0b110
* 6 - 1 = 5 =0b101
* 6 & 5 = 4 =0b100 > 0
* Did you find it? The bold 1 is still there!!!
* More generally, for any number n > 0
* n & n - 1 removes the last 1 in the binary form of n
* if and only if n is a power of two, there is only one 1 in the binary form of n
 *
 * Complexity:
 *  Time: O(1)
 *  space: O(1)
 */

fun isPowerOfTwo1(n: Int): Boolean {
    return n > 0 && n and n - 1 == 0
}

/** If a number is power of two, it can be recursively divided by 2 till it becomes 1
 * If the start number is 0 or if any intermediate number is not divisible by 2, we return false
 *
 * complexity:
 *  time: O(logn)
 *  space: O(1)
 * */

fun isPowerOfTwo2(n: Int): Boolean {
    if (n == 0) return false
    return n % 2 == 0 && isPowerOfTwo2(n / 2)
}