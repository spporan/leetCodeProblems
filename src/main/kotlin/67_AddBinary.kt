fun main() {
    val a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"
    val b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"
    println("binary sum ${addBinary("11", "1")}")

}

/**
 * solved 7. Add Binary using
 * @link https://leetcode.com/problems/add-binary/
 * Complexity:
 *  here,
 *   l1 = length of a
 *   l2 = length of b
 *
 *   time: O(max(l1, l2))
 *   space: O(max(l1, l2)
 */
fun addBinary(a: String, b: String): String {
    var result = ""
    var carry = 0
    val len1 = a.length
    val len2 = b.length
    val maxLen = kotlin.math.max(len1, len2)

    for (i in 0 until  maxLen) {

        val p = if (i < len1 ) a.codePointAt(len1 - 1 - i).minus('0'.toInt()) else 0
        val q = if (i < len2 ) b.codePointAt(len2 - 1 - i).minus('0'.toInt()) else 0
        val tempSum = p + q + carry
        carry = tempSum/2
        result = (tempSum % 2).toString() + result
    }

    return if (carry == 0) result else "1$result"
}

//simple solution using kotlin core method
fun addBinary1(a: String, b: String): String {
    return (a.toBigInteger(2)  +  b.toBigInteger(2)).toString(2)
}

