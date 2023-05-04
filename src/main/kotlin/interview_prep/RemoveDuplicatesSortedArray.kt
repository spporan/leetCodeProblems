package interview_prep

fun main() {
    val nums = intArrayOf(1,1,1,2,2,3)
    println("removed duplicates ${removeDuplicates(nums)}")
}

fun removeDuplicates(nums: IntArray): Int {
    var count = 0
    /**
     * 1st step:
     * count = 0
     * value = 1
     *
     * count = 0
     * value = 1
     *
     * count = 0
     * value = 1
     *
     * count = 1
     * value = 2
     * nums[1,2]
     *
     */
    nums.forEach {  value ->
        if ( value != nums[count]) {
            nums[++count] = value
        }
    }

    println("nums ${nums.toList()}")
    return count + 1
}