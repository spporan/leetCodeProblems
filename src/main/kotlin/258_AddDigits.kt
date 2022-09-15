fun main() {
    println("add digits ${addDigitsUsingMath(500)}")
}

/**
 * 258. Add Digits
 * https://leetcode.com/problems/add-digits/
 *
 * Complexity
 *  Time: O(n)
 *  Space: O(n)
 *
 */
fun addDigits(num: Int): Int {
    if (num / 10 == 0) return num

    var sum = 0
    var n = num
    while (n != 0) {
        val reminder = n % 10
        sum += reminder
        n /= 10
    }
    return addDigits(sum)
}

/**
 * Honestly , I couldn't come up with this approach on my own.
 * So, I read a few solutions in the discuss section.
 * They didn't explain the approach or the reason behind why it worked .
 * So I have thought an explanation myself.
 * The explanation might be incorrect ,( I doubt it though) , but the approach is correct.

 * The O(1) approach says :

 * Check if the number is 0 or not . If num==0 , return 0. Else do the following.
 * Check if (num%9)==0 . If it is true , return 9. Else return (num%9).
 * Math solution
 * dp problem
 *
 *  Complexity:
 *   Time: O(1)
 *   Space: O(1)
 */
fun addDigitsUsingMath(num: Int): Int {
    if (num == 0) return 0

    if (num % 9 == 0) return 9

    return num % 9
}