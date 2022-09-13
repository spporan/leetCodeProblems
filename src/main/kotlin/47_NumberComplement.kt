import kotlin.math.floor
import kotlin.math.ln

fun main() {
    println("complement ${findComplement2(5)}")
}

/**
 * 476. Number Complement
 * https://leetcode.com/problems/number-complement/
 *
 * Complexity:
 *  Time: (1)
 *  Space: (1)
 */
fun findComplement(num: Int): Int {
    if (num < 0) return 0

    val  binary = num.toString(2)
    var x = ""
    for (b  in binary) {
        val c = b.toInt().xor(1)
        x += c.toChar()
        println("binary ${b.code.xor(1)}")
    }

    return x.toInt(2)
}
//0011 // 100
/**
 *
 * An efficient approach to this problem is as follows:
 * 1. Find the number of bits in the given integer
 * 2. XOR the given integer with 2^number_of_bits-1
 *
 * Complexity:
 *  Time: O(logn)
 *  Space: O(1)
 */
fun findComplement1(num: Int): Int {
    val nBits = floor(ln(num.toDouble()) / ln(2.0) + 1).toInt()
    val shl = (1 shl nBits)
    val mask = shl - 1
    return num.xor(mask)
}

/**
 *
 * The naïve approach to solve the problem would be
 * first convert the given number into its binary
 * representation and then change every 1’s to 0
 * and 0’s to 1. After changing all 0’s and 1’s
 * convert the binary representation to number.
 *
 * Complexity:
 *  Time: O(logn)
 *  Space: O(logn)
 */
fun findComplement2(num: Int): Int {
    var  n = num
    val storageOfBinary: MutableList<Int> = mutableListOf()
    while (n != 0) {
        storageOfBinary.add(n % 2)
        n /= 2
    }
    var i = 0
    var j = storageOfBinary.size - 1

    while (i < j) {
        val temp = storageOfBinary[i]
        storageOfBinary[i] = storageOfBinary[j]
        storageOfBinary[j] = temp
        i ++
        j --
    }

    storageOfBinary.forEachIndexed { index, value ->
        storageOfBinary[index] = value xor 1
    }
    //  convert binary to decimal
    var two = 1
    for (i in storageOfBinary.size - 1 downTo 0) {
        n += storageOfBinary[i] * two
        two *= 2
    }
    println("arr $storageOfBinary")
    return n
}