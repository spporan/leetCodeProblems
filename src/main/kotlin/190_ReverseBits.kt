fun main() {
    println("reverse bits : ${reverseBits1(5)}")
}

fun reverseBits(n: Int): Int {
    var n = n
    if (n == 0) return 0
    var result = 0
    for (i in 0..31) {
        result = result shl 1
        println("shift ${result.toBinary(1)}")
        if (n and 1 == 1) result++
        n = n shr 1
    }
    return result
}

fun reverseBits1(n: Int): Int {
    var n = n
    if (n == 0) return 0
    var result = 0
    for (i in 0..31) {
        val bit = n and 1
        result = result shl 1 or bit
        n = n shr 1
    }
    return result
}
