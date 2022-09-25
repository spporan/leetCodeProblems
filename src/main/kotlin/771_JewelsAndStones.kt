fun main() {
    println("num of jewels ${numJewelsInStones("z",  "ZZ")}")
}

/**
 * Complexity:
 *  n = length of stones
 *
 *  Time: O(n)
 *  Space: O(1)
 */
fun numJewelsInStones(jewels: String, stones: String): Int {
    var count = 0
    for (char in stones) {
        if (jewels.contains(char)) {
            count += 1
        }
    }
    return count
}