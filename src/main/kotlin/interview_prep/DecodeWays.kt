package interview_prep

fun main() {
    println("Decode Ways ${numDecodings3("12312")}")
}

/**
 * Solved using bottom up approach
 * Complexity:
 *  time: O(n)
 *  space: O(n)
 */
fun numDecodings(s: String): Int {
    val dp = Array(s.length + 1) {0}
    dp[0] = 1
    dp[1] = if (s[0] == '0') 0 else 1

    for (i in 2 until dp.size) {
        val singleDig = s[i - 1].digitToInt()
        if (singleDig in 1..9) {
            dp[i] += dp[i - 1]
        }
        val doubleDig = s.slice(i-2 until  i).toInt()
        if (doubleDig in 10..26) {
            dp[i] += dp[i-2]
        }
    }
    return dp[s.length]
}

/**
 * Solved using top-down or memorize approach
 * Complexity:
 * Time: O(n)
 * Space: O(n)
 *
 */
fun numDecodings1(s: String): Int {
    val memo = Array(s.length) { -1 }
    return topDown(s, 0, memo)
}

private fun topDown(s: String, index: Int, memo: Array<Int>): Int {
    //base case: if the index reaches at the end of the string
    if (s.length == index) return 1 // this is a valid decoding

    //checking memorization table
    if (memo[index] != -1) {
        println("index $index memo ${memo[index]}")
        return memo[index]
    }


    //checking leading zero's in the string
    if (s[0] == '0') return 0 //invalid decoding

    //decoding single digit
    var ways = topDown(s, index + 1, memo)

    //decoding double-digit if possible
    if ( index + 1 < s.length && s.slice(index until index + 2).toInt() <= 26) {
        ways += topDown(s, index + 2, memo)
    }


    //memorizing the result
    println("index $index ways <>>> $ways")
    memo[index] = ways

    return ways
}


fun spaceOptWays(s: String): Int {
    var totalWays = 1
    var prevWays = 0

    for (i in s.length - 1 ..0) {
        var current = totalWays
        if (i + 1 < s.length && s.substring(i until 2) <= "26") {
            current += prevWays
        }
        if(s[i] == '0') current = 0
        prevWays = totalWays
        totalWays = current
    }

    return totalWays
}

fun numDecodings3(s: String): Int {
    val n: Int = s.length
    var totalWays = 1
    var prevWays = 0
    for (i in n - 1 downTo 0) {
        var curr = totalWays
        if (i + 1 < n && s.substring(i, i + 2) <= "26") curr += prevWays
        if (s[i] == '0') curr = 0
        prevWays = totalWays
        totalWays = curr
    }
    return totalWays
}