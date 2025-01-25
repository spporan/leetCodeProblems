package interview_prep

import kotlin.math.max

fun main() {
    println("Longest common subsequence ${longestCommonSubsequence("abcde", "ace")}")
}

/**
 * Time complexity: O(n^2)
 * Space Complexity: O(n^2)
 */
fun longestCommonSubsequence(text1: String, text2: String): Int {
    val len1 = text1.length
    val len2 = text2.length
    val dp = Array(text1.length + 1) {Array(text2.length + 1) {0} }
    for (i in 1 .. text1.length ) {
        for (j in 1 .. text2.length) {
            if (text1[i - 1] == text2[j - 1]) {
                dp[i][j] = dp[i-1][j-1] + 1
            } else {
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }
    return dp[len1][len2]
}