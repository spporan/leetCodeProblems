package interview_prep

import kotlin.math.abs


fun main() {
    val nums = intArrayOf(5,4,-1,7,8)
    println("maxSubArray ${maxSubArray(nums, 0,nums.size-1)}")
}

fun maxSubArrayUsingBruteForce(nums: IntArray): Int {
    var maxSum = nums[0]
    nums.forEachIndexed { index,value ->
        var currentSum = value
       for ((i, num) in nums.withIndex().drop(index + 1)) {
           currentSum  += num
           if (currentSum > maxSum) {
               maxSum = currentSum
           }
           //println("($value, $num)")
       }
    }
    return maxSum
}

fun maxSubArray(nums: IntArray): Int {
    var maxSum = Int.MIN_VALUE
    var currentSum = 0
    nums.forEach {
        currentSum += it
        if (currentSum > maxSum) {
            maxSum = currentSum
        }
        if (currentSum < 0) {
            currentSum = 0
        }
    }
    return maxSum
}

fun maxSubArray(nums: IntArray, p: Int, r: Int):Int {
    if (p == r) return nums[p]
    val q = (p + r) / 2
    val left = maxSubArray(nums, p, q)
    val right = maxSubArray(nums, q + 1, r)
    val cross = maxCrossingSum(nums, p, q, r)
    return maxOf(left, right, cross)
}

fun maxCrossingSum(nums: IntArray, p: Int, q: Int, r: Int): Int {
    var sum = 0
    var leftSum = Int.MIN_VALUE
    for (i in q downTo p) {
        sum += nums[i]
        if (sum > leftSum) {
            leftSum = sum
        }
    }

    var rightSum = Int.MIN_VALUE
    sum = 0
    for (i in q + 1 ..r) {
        sum += nums[i]
        if (sum > rightSum) {
            rightSum = sum
        }
    }
    return leftSum + rightSum
}

