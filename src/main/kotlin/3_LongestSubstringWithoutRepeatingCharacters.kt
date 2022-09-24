import kotlin.math.max

fun main() {
    println("longest substring  ${lengthOfLongestSubstring( "abcabcbb")}")
}

/**
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Time Complexity: O(n) where n is the length of the string.
 * Space Complexity: O(128) for the nextIndex array.
 *
 */

fun lengthOfLongestSubstring(s: String): Int {
    val n = s.length
    var longest = 0
    val nextIndex = IntArray(128)
    var r = 0
    var l = 0
    while (r < n) {
        l = max(nextIndex[s[r].toInt()], l)
        //l = nextIndex[s[r].code].coerceAtLeast(l)
        //longest = longest.coerceAtLeast(r - l + 1)

        longest = max(longest, r - l + 1) //longest.coerceAtLeast(r - l + 1)

        nextIndex[s[r].toInt()] = r + 1
        r++
    }
    return longest
}