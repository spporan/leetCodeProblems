fun main() {
    println("num of way ${climbStairsBottomUp(5)}")
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

fun climbStairsUsingMemo(
    targetValue: Int,
    memo: HashMap<Int, Int> = hashMapOf()
): Int {
    if (targetValue == 0 || targetValue == 1) return 1
    if (!memo.contains(targetValue)) {
        memo[targetValue] = climbStairsUsingMemo(targetValue - 1, memo) + climbStairsUsingMemo(targetValue - 2, memo)
    }
    return memo.getValue(targetValue)
}

fun climbStairsUsingBruteForce(targetValue: Int, init: Int = 0): Int {

    if (init == targetValue) return 1

    if (init > targetValue) return 0
    return climbStairsUsingBruteForce(targetValue, init + 1) +
            climbStairsUsingBruteForce(targetValue, init + 2)

}

/**
 * this loop run n-1 times
 *
 * complexity
 *
 *  time: O(n-1) = O(n)
 *  space: O(n-1) = O(1)
 */
fun climbStairsDP(n: Int): Int {

    var one = 1
    var two = 1

    for (i in 1 until n) {
        val temp =  one
        one += two
        two = temp
    }
    return one
}
/**
 * Solved leetCode problem no: 70 Climbing Stairs using recursive approach
 * https://leetcode.com/problems/climbing-stairs/
 *  complexity:
 *  here,
 *    n = input number n
 *
 *  time: O(2^n)
 *  space: O(n)
 *
 */
fun climbStairsRecursive(n: Int): Int {
    if (n == 0 || n == 1) return 1

    return climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2)
}

/**
 * DP solution with bottom up or tabulation approach
 *  time: O(n)
 *  space: O(n)
 */
fun climbStairsBottomUp(n: Int): Int {
    if (n == 0 || n == 1) return 1

    val table = Array(n + 1) { 0 }
    table[0] = 1
    table[1] = 1
    for (i in 2 until  table.size) {
        table[i] = table[i - 1] + table[i - 2]
    }

    return table[n]
}