

fun main() {
    println("Intersection of Two Arrays ${intersection(intArrayOf(4,9,5), intArrayOf(9,4,9,8,4)).toList()}")
}

/**
 * 349. Intersection of Two Arrays
 * https://leetcode.com/problems/intersection-of-two-arrays/
 *
 * Complexity:
 *  here,
 *   m = Size of nums1
 *   n = size of nums2
 *  Time: (m + n)
 *  Space: (m + n) // when all elements are different of each array. That's the worst case
 */
fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val numsSet1 = nums1.toHashSet()
    val numsSet2 = nums2.toHashSet()
    val result = mutableListOf<Int>()
    for (value in numsSet1) {
        if (numsSet2.contains(value)) {
            result.add(value)
        }
    }
    return result.toIntArray()
}