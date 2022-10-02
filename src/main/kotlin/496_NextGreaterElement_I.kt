import java.util.Stack

fun main() {
    println("next greater nums ${nextGreaterElementBitOptimized(nums1 = intArrayOf(2, 4), nums2 = intArrayOf(1,2,3,4)).toList()}")
}

/**
 * This is the O(n*n) time solution.
 * https://leetcode.com/problems/next-greater-element-i/
 */
fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
    val ans = intArrayOf().toMutableList()
    var ansVal = -1
    var currSubValFound: Boolean
    nums1.mapIndexed mapI@ { indI, valueI ->
        currSubValFound = false
        nums2.mapIndexed mapJ@ { indJ, valueJ ->
            if (valueI == valueJ) {
                ansVal = -1
                currSubValFound =  true
            } else if( currSubValFound && valueI < valueJ) {
                ansVal = valueJ
                ans.add(ansVal)
                currSubValFound = false
                return@mapI
            }
        }
        ans.add(ansVal)
    }
    return ans.toIntArray()
}

/**
 * Time complexity: O(n)
 * Space: O(n)
 */
fun nextGreaterElementBitOptimized(nums1: IntArray, nums2: IntArray): IntArray {
    //nums1 is the subset of nums2
    val map : HashMap<Int, Int> = hashMapOf()
    val stack: Stack<Int> = Stack()

    nums2.map {nextNum ->
        while (stack.isNotEmpty() && nextNum > stack.peek()) {
            map[stack.pop()] = nextNum
        }
        stack.push(nextNum)
    }

    nums1.mapIndexed { index, i ->
        nums1[index] = map.getOrDefault(i, -1)
    }
    return nums1
}