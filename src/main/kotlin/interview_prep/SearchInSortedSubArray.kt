package interview_prep

fun main() {
    println("Search ${search(intArrayOf(1), 1)}")
}

fun search(nums: IntArray, target: Int): Int {
    var l = 0
    var r = nums.size -1
    var find = -1
    while (l <= r) {
        val m = (l + r)/2
        if(nums[m] == target){
            find = m
           break
        }
        if (nums[l] < nums[m]) {
            if (nums[l] <= target && nums[m] >= target) {
                r = m - 1
            } else {
                l = m + 1
            }
        } else {
            if (nums[m] < target && nums[r] >= target) {
                l = m + 1
            } else {
                r = m - 1
            }
        }
    }
    return find
}