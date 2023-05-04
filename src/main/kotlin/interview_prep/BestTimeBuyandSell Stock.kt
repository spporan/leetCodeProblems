package interview_prep

fun main() {
    println("maxProfit ${maxProfit(intArrayOf(7,1,5,3,6,4))}")

}

fun maxProfit(prices: IntArray): Int {
    var maxProfit = 0
    var leastValue: Int = Int.MAX_VALUE

    prices.forEach { price ->
        if (price < leastValue ) {
            leastValue = price
        }

        val priceForToday = price - leastValue
        if (priceForToday > maxProfit) {
            maxProfit = priceForToday
        }
    }

    return maxProfit
}
