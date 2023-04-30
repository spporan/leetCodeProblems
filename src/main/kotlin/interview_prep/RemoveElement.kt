package interview_prep

fun main() {
    val nums = intArrayOf(3,2,2,3)
    val `val` = 2
    println("value of k ${removeElement(nums, `val`)}")
}

fun removeElement(nums: IntArray, `val`: Int): Int {
    var count = 0

    nums.forEach { num ->
        if (num != `val`) {
            nums[count++] = num
        }
    }
    println("nums ${nums.toList()}")
    return  count
}