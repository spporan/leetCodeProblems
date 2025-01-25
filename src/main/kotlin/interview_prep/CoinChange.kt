package interview_prep

import kotlin.math.min

fun main() {
    println("Num of coin ${coinChange(intArrayOf(1, 2, 5), 11)}")
}

/**
 * Time complexity O(amount * coins.size)
 * Space complexity O(amount)
 */
fun coinChange(coins: IntArray, amount: Int): Int {
    val dp = Array(amount + 1) { amount + 1 }
    dp[0] = 0
    for (i in 1..amount) {
        for (coin in coins) {
            if (i - coin >= 0) {
                dp[i] = min(dp[i], 1 + dp[i - coin])
            }
        }
    }
    return if (dp[amount] != amount + 1) dp[amount] else -1
}