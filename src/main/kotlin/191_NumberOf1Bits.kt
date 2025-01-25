fun main() {
    println("Number of bits 1's: ${hammingWeight4(2147483645)}")
}

/**
 * 191. Number of 1 Bits
 * https://leetcode.com/problems/number-of-1-bits/
 *
 * Complexity:
 *  Time:  O(1)
 *  Space: O(1)
 */
fun hammingWeight2(n:Int):Int {
    var count = 0
    var number = n
    for (i in 0..31) {
        val cal = (number and 1)
        println("number $number cal $cal")
        if (cal == 1) count++
        number = number shr 1
    }
    return count
}


/**
 * 191. Number of 1 Bits
 * https://leetcode.com/problems/number-of-1-bits/
 *
 * Complexity:
 *  Time:  O(1)
 *  Space: O(1)
 *
 * Explanation:  n = 5
 * 5 = 101
 * and
 * 4 = 100
 *
 * m = 100
 *
 * m = m and m -1 = 100 and 011
 */
fun hammingWeight(n:Int):Int {
    var m = n
    var ans = 0
    while(m != 0){
        m = m and (m-1)
        ans++
    }
    return ans
}

fun hammingWeight3(n:Int):Int {
    var m = n
    var ans = 0
    while(m != 0){
        val calm = m and 1
        if (calm == 1) {
            ans++
        }
        m = m shr 1

    }
    return ans
}

fun hammingWeight1(n:Int):Int {
    var count = 0
    var number = n
    while (number > 0) {
        if (number % 2 == 0) {
            number /= 2
        } else {
            number = (number - 1)/2
            count += 1
        }
    }
    return count
}

fun hammingWeight4(n:Int):Int {
    var count = 0
    var number = n
    while (number > 0) {
        if (number % 2 == 1) {
            count += 1
        }
        number /= 2
    }
    return count
}