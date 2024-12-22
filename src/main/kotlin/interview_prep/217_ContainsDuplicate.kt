import kotlin.math.abs

fun main() {
    println("is duplicate in  the list ${containsDuplicate(intArrayOf(9,0,-2))}")
}

/**
 * 217. Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/submissions/
 *
 * Complexity:
 *   Time: O(n)
 *   Space: O(n)
 */
fun containsDuplicate(nums: IntArray): Boolean {
    val hashMap: HashMap<Int, Int>  = hashMapOf()
    for (num in  nums) {
        if (hashMap.containsKey(num)) return true
        hashMap[num] = 1
    }
    return false
}

