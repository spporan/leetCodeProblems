fun main() {
    println("num of way ${climbStairs(45)}")
}

/**
 * Solved leetCode problem no: 70 Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/
 *  complexity:
 *  here,
 *    n = input number n
 *
 *  time: O(n * 2) = O(n)
 *  space: O(n)
 *
 */

fun climbStairs(n: Int): Int {
    val table = Array(n + 1) { _-> 0}
    table[0] = 1

    table.forEachIndexed { index, check ->
        if (check > 0) {
            for (num in 1..2) {
                if (index + num <= n) {
                    table[index + num] += table[index]
                }
            }
        }
    }

    return table[n]
}