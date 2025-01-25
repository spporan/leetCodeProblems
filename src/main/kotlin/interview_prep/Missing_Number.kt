package interview_prep

fun main() {
    println("Missing number ${missingNum(intArrayOf(9,6,4,2,3,5,7,0,1))}")
}

fun missingNumber(nums: IntArray): Int {
    val n = nums.size
    for (i in 0..n) {
        if (!nums.contains(i)) return i
    }

    return -1
}

/**
 * Approach 2: Solved by xoring elements
 * Complexity
Time complexity:
O(n)

Space complexity:
O(1)

 * **/
fun missingNumber1(nums: IntArray): Int {
    val n = nums.size
    var ans = 0
    for (i in 1..n) {
        ans = ans xor i
    }

    for (num in nums) {
        ans = ans xor num
    }
    return ans
}

/**
 * Approach 3(Sum of all elememnts)
 * Time complexity:
O(n)

Space complexity:
O(1)
 *
 */
fun missingNum(nums: IntArray): Int {
    val n = nums.size
    val sumOfN = n * (n + 1)/2
    var sum = 0
    for (num in nums) {
        sum += num
    }

    return sumOfN - sum
}