package interview_prep

fun main() {
    println("maxProduct ${maxProduct(intArrayOf(2,3,-2,4))}")
}

fun maxProduct(nums: IntArray): Int {
    var min = nums[0]
    var maxProduct = nums[0]
    var result = maxProduct

    for  (i in 1 until nums.size) {
        val tempMax = maxOf(maxProduct * nums[i], min * nums[i], nums[i])
        min = minOf(maxProduct * nums[i], min * nums[i], nums[i])
        maxProduct = tempMax
        result = maxOf(maxProduct, result)
    }
    return result
}