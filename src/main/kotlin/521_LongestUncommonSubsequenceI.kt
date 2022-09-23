import kotlin.math.max

fun main() {
    println("find length ${findLUSlength("aba", "cdc")}")
}

/**
 * 521. Longest Uncommon Subsequence I
 * https://leetcode.com/problems/longest-uncommon-subsequence-i/solution/
 *
 * Time complexity : O(min(x,y))
 * where x and y are the lengths of strings a and b respectively.
 * Here equals method will take min(x,y) time .
 * Space complexity : O(1). No extra space required.
 */
fun findLUSlength(a: String, b: String): Int {
    if (a == b) return -1

    return max(a.length, b.length)
}