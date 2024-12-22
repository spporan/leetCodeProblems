package interview_prep

fun main() {
    twoSum(intArrayOf(2,7,11,15), 9)
    println("Max profit ${maxProfit3(intArrayOf(2,7,11,15))}")
}

/**
 * Two sum problem https://leetcode.com/problems/two-sum/description/
 * time complexity is O(n)
 * space complexity is O(n)
 */
fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    for ((index, value) in nums.withIndex()) {
        val remaining = target - value
        if (map.containsKey(remaining)) {
            return intArrayOf(map.getOrDefault(remaining, 0), index)
        }
        map[value] = index
    }
    return intArrayOf()
}

private fun  maxProfit1(prices: IntArray): Int {
    var maxProfit = 0
    prices.forEachIndexed { index, buyingPrice->
        for ((ind, sellingPrice) in prices.withIndex().drop(index + 1)) {
            val prof =  sellingPrice - buyingPrice
            if (prof > maxProfit) {
                maxProfit = prof
            }
        }
    }
    return maxProfit
}

 fun  maxProfit3(prices: IntArray): Int {
    var maxProfit = 0
    var leastPrice = Int.MAX_VALUE
    prices.forEachIndexed { index,price->
        if (leastPrice > price) {
            leastPrice = price
        }

        val profit = price - leastPrice
        if (profit > maxProfit) {
            maxProfit = profit
        }
    }
    return maxProfit
}