/**
 * link of problem description
 * @link https://leetcode.com/problems/find-the-difference/
 */

fun main() {
    println("difference ${findTheDifference("eerr", "erree")}")
}

/**So, here also let's say our character are:
 * s = abc
 * t = cabx
 *
 * if we take XOR of every character. all the n character of s "abc" is similar to n character of t "cab". So, they will cancel each other.
 * And we left with our answer.
 *
 * s =   abc
 * t =   cbax
 * ------------
 * ans -> x
 * -----------
 * */

fun findTheDifference(s: String, t: String): Char {
    var c = 0.toChar()
    for (cs in s.toCharArray()) c = (c.code xor cs.code).toChar()
    for (ct in t.toCharArray()) c = (c.code xor ct.code).toChar()
    return c
}


/**
 * This  problem solved by asci code summation for two string and difference those sum of asci
 */
fun findTheDifferenceASCISum(s: String, t: String): Char {
    var sum1 = 0
    var sum2 = 0
    for (element in s) {
        sum1 += element.code
    }
    for (element in t) {
        sum2 += element.code
    }
    return (sum2 - sum1).toChar()
}