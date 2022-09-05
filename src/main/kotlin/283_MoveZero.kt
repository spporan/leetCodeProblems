fun main() {

    val arr = intArrayOf(0, 1, 0, 3, 12)
    moveZeroes(arr)
    println("Int arr ${arr.toList()}")
}

/**
 * Solved 282. Move zero
 * https://leetcode.com/problems/move-zeroes/submissions/
 *
 * Complexity
 *  time: O(n)
 *  space: O(n)
 */
fun moveZeroes(nums: IntArray): Unit {
    if (nums.isEmpty()) return
    var  current = 0
    for (i in nums.indices) {
        if (nums[i] != 0)  {
            val temp  = nums[current]
            nums[current]  = nums[i]
            nums[i] = temp
            current ++
        }
    }
}