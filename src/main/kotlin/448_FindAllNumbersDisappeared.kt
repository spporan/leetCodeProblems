fun main() {
    println("Disappeared number ${findDisappearedNumbers(intArrayOf(1,1))}")
}

/**
 * Solved 448. Find All Numbers Disappeared in an Array
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 *
 * Complexity:
 *  Time: O(n)
 *  Space: O(n)
 */
fun findDisappearedNumbers(nums: IntArray): List<Int> {
    val hasSet: HashSet<Int> = nums.toHashSet()
    val list: MutableList<Int> = mutableListOf()
    for (i in 1..nums.size) {
        if (!hasSet.contains(i)) {
            list.add(i)
        }
    }
    return list
}