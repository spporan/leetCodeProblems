package interview_prep

fun main() {
    println("sum of two integer ${getSum(20,30)}")
}


fun getSum(a: Int, b: Int): Int {
    var a = a
    var b = b
    while (b != 0) {
        val sum = a xor b // sum without carry
        val carry = a and b shl 1 // carry shifted left
        a = sum
        b = carry
        println("carry $b")
    }
    return a
}