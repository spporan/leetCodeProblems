package interview_prep

fun main() {
    twoSum(intArrayOf(2,7,11,15), 9)
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