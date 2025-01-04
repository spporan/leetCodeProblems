package interview_prep


fun main() {
    val nums2 = intArrayOf(4,5,6,7,0,1,2)
    println("findMin ${findMin(nums2)}")
}
fun findMin(nums: IntArray): Int {
    var l = 0
    var r = nums.size-1
    while (l < r) {
        val m = (l + r)/2
        if (nums[m] > nums[r]) {
            l = m + 1
        } else {
            r = m
        }
    }
    return nums[l]
}

fun findMin(nums: IntArray, l: Int, r: Int): Int {
    val m = (l + r)/2
    return if ( nums[r] > nums[m]) {
        findMin(nums, l, m)
    } else if (nums[r] < nums[m]){
        findMin(nums, m + 1, r)
    } else if (nums[r] >= nums[l]) {
        nums[l]
    } else {
        nums[l]
    }
}