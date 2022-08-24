fun main() {
    println("single num ${singleNumber2(intArrayOf(4,1,2,1,2))}")
}
fun singleNumber1(nums: IntArray): Int {
    val result: HashMap<Int, Int> = hashMapOf()
    nums.forEachIndexed { index, number ->
        if (result.containsKey(number)) {
            result[number] = result.getValue(number) + number
        } else {
            result[number] = 1
        }
    }
    var res = 0
    result.keys.forEach { key ->
        if (result.getValue(key) == 1)
            res = key
    }
    return res

}

fun singleNumber(nums: IntArray): Int {
    val res: MutableSet<Int> =  mutableSetOf()

    nums.forEachIndexed { index, number ->
        if (res.contains(number)) {
            res.remove(number)
        } else {
            res.add(number)
        }
        println("res $res")

    }
    return res.last()

}

/**
 * solved 136 Single number
 * https://leetcode.com/problems/single-number/
 *
 * complexity
 *  time:
 *   O(n)
 *   space: O(1)
 */
fun singleNumber2(nums: IntArray): Int {

    var res = 0
    nums.forEachIndexed { index, number ->
        res = res xor number
        println("res $res")

    }
    return res

}