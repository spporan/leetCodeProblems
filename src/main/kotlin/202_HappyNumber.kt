fun main() {
    println("is happy ${isHappy(19)}")
}

/**
 * Solved happy problem by my own  way
 * 202. Happy Number
 * https://leetcode.com/problems/happy-number/
 * Complexity,
 *  time: O(m * n)
 *  space: O(1)
 */
fun isHappy(n: Int): Boolean {
    var current = n.toString()

    while (current != "1"  && current.toInt() > 6) {
        var sum = 0
       current.map {
           println("num $it")
       val num = it.toString().toInt()
           sum += num * num
       }
        println("sum $sum")
        current = sum.toString()
    }
    return current == "1"
}

/**
 * Tried to solve another way
 * 202. Happy Number
 * https://leetcode.com/problems/happy-number/
 * Complexity
 *  here,
 *    time :O(log(n))
 *    space: O(log(n))
 */
fun isHappy2(n: Int): Boolean {
    val hashSet = hashSetOf<Int>()
    var calSum = getSquareSum(n)
    while (!hashSet.contains(calSum)) {
        if (calSum == 1) return true
        hashSet.add(calSum)
        calSum = getSquareSum(calSum)
    }
    println("set $hashSet")
    return false
}

private fun getSquareSum(num: Int): Int {
    var current = num
    var sum = 0
    for (i in 0 until num.toString().length) {
        val digit  =  current % 10
        current /=  10
        sum += digit * digit
    }
    return sum
}



