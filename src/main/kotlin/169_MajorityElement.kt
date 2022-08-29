fun main() {
    println("majority ${majorityElement(intArrayOf(3,2,3))}")
}

/**
 * Solved problem 169. Majority Element
 * https://leetcode.com/problems/majority-element/
 *
 * Complexity
 *  here,
 *   n = size of the nums
 *   time: O(n)
 *   space: O(n)
 */
fun majorityElement(nums: IntArray): Int {
    val memo:  HashMap<Int, Int> = hashMapOf<Int, Int>()

    nums.forEach { num ->
        if (memo.containsKey(num)) {
            memo[num] = memo.getValue(num) +  1
        } else {
            memo[num] = 1
        }
    }
    var maxCount = Int.MIN_VALUE
    var  maxkey = 0
    memo.keys.map {  key ->
        val count = memo.getValue(key)
        if (maxCount < count) {
            maxCount = count
            maxkey = key
        }
    }
    return maxkey
}

fun majorityElement1(nums: IntArray): Int { // 2,2,1,1,1,2,2
    var value = 0
    var index = 0
    for (i in nums.indices) {
        if (nums[index] == nums[i]) {
            value++
        }
        if (nums[index] != nums[i]) {
            value--
        }
        if (value == 0) {
            index = i //considers the current value as a majority value
            value = 1 //for including the current value
        }
    }
    return nums[index]
}
