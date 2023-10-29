package interview_prep

fun main() {
    println("max profit ${maxProfit2(intArrayOf(7,1,5,3,6,4))}")
}

fun maxProfit2(prices: IntArray): Int {
    var maxProfit = 0

    for (i in 1 until prices.size) {
        if (prices[i-1] < prices[i]) {
            maxProfit += prices[i] - prices[i - 1]
        }
    }
    return maxProfit
}