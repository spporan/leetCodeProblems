package interview_prep

import kotlin.math.max

fun main() {
    println("rob ${robUsingDp2(intArrayOf(2,1,1,2))}")
}

/**
 * Solved using constant space
 * Complexity:
 *  Time: O(n)
 *  Space: O(1)
 */
fun rob(nums: IntArray): Int {
    var prevRobbed = 0
    var maxRobb = 0
    for (i in nums.indices) {
        val temp = max(maxRobb, prevRobbed + nums[i])
        prevRobbed = maxRobb
        maxRobb = temp
    }
    return maxRobb
}


/**
 * Solved using dp approach
 * Complexity:
 *  Time: O(n)
 *  Space: O(n)
 */
fun robUsingDp(nums: IntArray): Int {
    println("nums ${nums.toList()}")
    if (nums.size == 1) return nums[0]
    val dp = Array(nums.size) { 0 }
    dp[0] = nums[0]
    dp[1] = max(nums[0], nums[1])
    for (i in 2 until nums.size) {
        dp[i] = max(dp[i - 1], nums[i] + dp[i - 2])
    }
    return dp[nums.size - 1]
}


fun robUsingDp2(nums: IntArray): Int {
    if (nums.size == 1) return nums[0]
    val l1 = nums.toList().subList(0, nums.size - 1).toIntArray()
    val l2 = nums.toList().subList(1, nums.size).toIntArray()

    return max(robUsingDp(l1), robUsingDp(l2))
}
