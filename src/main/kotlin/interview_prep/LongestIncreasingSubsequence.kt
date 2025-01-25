package interview_prep

fun main() {
    println("Longest sub increase seq ${lengthOfLIS(intArrayOf(4,10,4,3,8,9))}")
}

fun lengthOfLIS(nums: IntArray): Int {
    val list = mutableListOf<Int>()
    list.add(nums[0])
    for (i in 1 until nums.size) {
        if (list[list.size - 1] < nums[i]) {
            list.add(nums[i])
        } else {
            val findIndx = findIndxInList(list, nums[i])
            list[findIndx] =  nums[i]
        }
    }

    println("result list $list")
    return list.size
}

private fun findIndxInList(list: List<Int>, value: Int): Int {
    var l = 0
    var h = list.size - 1
    while (l <= h) {
        val m = l + (h - l)/2
        val middle = list[m]
        if (middle == value) return m
        else if (middle < value) {
            l = m + 1
        } else {
            h = m - 1
        }
    }
    return l
}