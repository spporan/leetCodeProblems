package interview_prep

import kotlin.math.max

fun main() {
    println("rob ${robb(intArrayOf(2,1,1,2))}")
}

private fun robb(nums: IntArray): Int {
    if (nums.size == 1) return nums[0]
    return max(maxRobbed(nums, 0, nums.size - 2), maxRobbed(nums, 1, nums.size - 1))
}

private fun maxRobbed(nums: IntArray, startIndx: Int, endIndx: Int): Int {
    var prevRobbed = 0
    var maxRobbed = 0
    for (i in startIndx .. endIndx) {
        val temp = max(maxRobbed, prevRobbed + nums[i])
        prevRobbed = maxRobbed
        maxRobbed = temp
    }
    return maxRobbed
}