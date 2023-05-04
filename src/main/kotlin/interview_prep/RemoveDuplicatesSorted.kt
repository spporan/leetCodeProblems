package interview_prep

fun main() {
    println("removes duplicate ${removeDuplicate11(intArrayOf(1,1,2))}")
}

fun removeDuplicate11(nums: IntArray): Int {
    var count = 1
    var index = 1


    for(i in 1 until nums.size) {
        if (nums[i] == nums[i - 1]) {
            count ++
        } else {
            count = 1
        }

        if (count <= 2) {
            nums[index++] = nums[i]
        }
    }
    return index
}