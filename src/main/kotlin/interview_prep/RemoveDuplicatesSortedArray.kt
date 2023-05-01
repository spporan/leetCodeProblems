package interview_prep

fun main() {
    val nums = intArrayOf(0,0,1,1,1,2,2,3,3,4)
    println("removed duplicates ${removeDuplicates(nums)}")
}

fun removeDuplicates(nums: IntArray): Int {
    var count = 0

    nums.forEach {  value ->
        if ( value != nums[count]) {
            nums[++count] = value
        }
    }
    return count + 1
}