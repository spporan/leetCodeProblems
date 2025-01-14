package interview_prep

import java.util.*


fun main() {
    println("3 sum ${threeSum(intArrayOf(-1,0,1,2,-1,-4))}")

}

fun threeSum(nums: IntArray): List<List<Int>> {
    val result: MutableList<List<Int>> = ArrayList()

    //val result = mutableListOf<List<Int>>()
    nums.sort()
    println("nums ${nums.toList()}")

    for (i in 0 until nums.size - 2) {
        if (i > 0 && nums[i] == nums[i - 1]) continue
        var j = i + 1
        var k = nums.size - 1
        while (j < k) {
            val sum = nums[i] + nums[j] + nums[k]
            if (sum == 0) {
                //Found a triple elements
                result.add(listOf(nums[i], nums[j], nums[k]))
                j++
                k--

                //skip duplicates for j
                while(j < k && nums[j] == nums[j-1]) {
                    j++
                }

                while (j < k && nums[k] == nums[k+1]) {
                    k--
                }
            } else if (sum > 0) {
                // sum is greater than zero, decrement the k to decrease sum
                k--
            } else {
                //sum is less than zero, increment j to increase sum
                j++
            }

        }
    }

    println("items contain ${result.contains(listOf(-1, 1, 0))}")
    return result
}

fun threeSum1(arr: IntArray): List<List<Int>>? {
    val len = arr.size
    val ans: MutableList<List<Int>> = ArrayList()
    //Arrays.sort(arr)
    arr.sort()
    println("nums ${arr.toList()}")

    for (i in 0 until len - 2) {
        if (i > 0 && arr[i] == arr[i - 1]) continue
        var j = i + 1
        var k = len - 1
        while (j < k) {
            val sum = arr[i] + arr[j] + arr[k]
            if (sum == 0) {
                ans.add(listOf(arr[i], arr[j], arr[k]))
                j++
                k--
                while (j < k && arr[j] == arr[j - 1]) {
                    j++
                }
                while (j < k && arr[k] == arr[k + 1]) {
                    k--
                }
            } else if (sum > 0) {
                k--
            } else {
                j++
            }
        }
    }
    return ans
}