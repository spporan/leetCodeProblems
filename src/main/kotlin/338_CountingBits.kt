fun main() {
    println("count bits ${countBits1(5).toList()}")
}

/**
 * 338. Counting Bits
 * https://leetcode.com/problems/counting-bits/
 *
 * Complexity:
 *  Time: O(nlogn)
 *  Space: O(n)
 *
 *
 */
fun countBits(n: Int): IntArray {
    val array = IntArray(n + 1) { _ -> 0 }
    for (i in 0 .. n) {

        array[i] = getDecimalToBinary(i)
    }
    return array
}

private fun getDecimalToBinary(n: Int): Int {
    var temp = n
    var count = 0
    while (temp != 0) {
        val reminder = temp % 2
        temp /= 2
        if (reminder == 1) {
            count ++
        }
    }
    return count
}

/**
 * Dp  solution
 *
 *  Complexity
 *   Time: O(n)
 *   Space: O(n)
 */
fun countBits1(n: Int): IntArray {
    val array = IntArray(n + 1) { _ -> 0 }

    for (i in 0 .. n) {
        array[i] = array[i/2]
        if (i % 2 == 1)
            array[i] ++
    }
    return array
}
