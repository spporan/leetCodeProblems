import kotlin.math.max

fun main() {
    println("max profit ${maxProfit2(intArrayOf(7,1,5,3,6,4))}")
}

/**
 * Solved 121. Best Time to Buy and Sell Stock
 * here the problem link https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * Complexity:
 *  here,
 *   n = size of the prices
 *
 *  time: O(n)
 *  space: 0(1)
 *
 *  explanation of the output:
 *   Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *   Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 */
fun maxProfit(prices: IntArray): Int {
    var maxProfit = 0
    var leastValue = Int.MAX_VALUE
    prices.forEachIndexed { _, price ->
        if (leastValue > price) {
            leastValue = price
        }

        val profitToday = price - leastValue
        if (profitToday > maxProfit) {
            maxProfit = profitToday
        }
    }
    return maxProfit
}

fun maxProfit2(prices: IntArray): Int {
    var maxProfit = 0
    var buy = 0  //left
    var sell = 1 // right
    while (sell <  prices.size) {
        var currentProfit = prices[sell]  - prices[buy]
        if (prices[sell] > prices[buy]) {
            maxProfit = max(currentProfit, maxProfit)
        } else {
            buy = sell
        }
        sell ++
    }
    return maxProfit
}

