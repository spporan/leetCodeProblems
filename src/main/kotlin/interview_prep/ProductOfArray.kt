package interview_prep

fun main() {
    println("productExceptSelf ${productExceptSelf1(intArrayOf(2,3,4,5)).toList()}")

}

fun productExceptSelf(nums: IntArray): IntArray {
    val arr = IntArray(nums.size) {0}
    //9,0,-2
    arr[0] = nums[0]
    var product = 1
    for (i in 1 until nums.size) {
        arr[i] = arr[i - 1] * nums[i]
    }
    println("arr ::${arr.toList()}")
    for (i in nums.size - 1 downTo  1 ) {
        arr[i] = product * arr[i -1]
        product *= nums[i]
    }
    arr[0] = product
    return arr
}

/** Time complexity is O(n)
** space complexity is O(n)*/
fun productExceptSelf1(nums: IntArray): IntArray {
    val productArr = IntArray(nums.size) {1}
    //[2,3,4,5]

    for (i in 1 until nums.size) {
        productArr[i] = productArr[i - 1] * nums[i - 1]
    }
    //[1,2,6,24]
    var right = nums.last()
    println("arr ::${productArr.toList()}")
    for (i in nums.size - 2 downTo  0 ) {
        productArr[i] = right * productArr[i]
        right *= nums[i]
    }
    return productArr
}