fun main() {
    println("num of way ${climbStairsDP(45)}")
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
    init: Int = 0,
    memo: HashMap<Int, Int> = hashMapOf()
): Int {
    if (memo.containsKey(init)) return memo.getValue(init)
    if (init == targetValue) return 1

    if (init > targetValue) return 0

    val result = climbStairsUsingBruteForce(targetValue, init + 1) +
            climbStairsUsingBruteForce(targetValue, init + 2)
    memo[init] = result

    return memo.getValue(init)

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
 *  space: O(n-1) = O(n)
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