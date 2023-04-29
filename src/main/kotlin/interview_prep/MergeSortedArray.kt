package interview_prep
fun main() {
    val nums1 = intArrayOf(4,5,6,0,0,0)
    val m = 3
    val nums2 = intArrayOf(1,2,3)
    val n = 3
    merge(nums1, m, nums2, n)
}

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var i = m-1 // pointing index of the array of nums1 which index value is the largest value of nums1
    var j = n-1 // pointing last index of the array nums2
    var k = nums1.size - 1 //pointing last index of the array of nums1

    while (j >=0 ) {
        // If element at i index of nums1 > element at j index of nums2
        // then it is largest among two arrays and will be stored at k position of nums1
        // using i>=0 to make sure we have elements to compare in nums1 array
        if (i >= 0 && nums1[i] > nums2[j]) {
            nums1[k] = nums1[i]
            k -= 1
            i -= 1
        } else {
            // element at j index of nums2 array is greater than the element at i index of nums1 array
            // or there is no element left to compare with the nums1 array
            // and we just have to push the elements of nums2 array in the nums1 array.
            nums1[k] = nums2[j]
            j -= 1
            k -= 1
        }
    }
    nums1.map { println(it) }
}