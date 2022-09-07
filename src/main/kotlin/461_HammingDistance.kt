fun main() {
    println("hammingDistance ${hammingDistance(1,
        5)}")
}

/**
 * Solved hammingDistance
 *
 * Complexity:
 *  Time: O(31) = O(1)
 *  Space: O(31) = O(1)
 */
fun hammingDistance(x: Int, y: Int): Int {
    val  b1 = x.toBinary(31)
    val b2 = y.toBinary(31)

    var count = 0
    val map: HashMap<Int, Char> = hashMapOf()
    b1.forEachIndexed { index, char ->
        map[index] = char
    }

    b2.forEachIndexed {index, char ->
        if (map.getValue(index) != char) {
            count += 1
        }
    }
    return count

}

fun Int.toBinary(len: Int): String {
    return String.format("%" + len + "s", this.toString(2)).replace(" ".toRegex(), "0")
}
