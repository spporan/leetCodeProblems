/**
 * @link https://leetcode.com/problems/roman-to-integer/
 * Roman to integer conversion
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * Example: DCXLIX = D + C + XL + IX = 500 + 100 + 40 + 9 = 649.
 */
fun main() {
    println("integer number ${romanToIntAnother("MCMXCIV")}")
}

//firstly I submitted solution using this approach and accepted
fun romanToInt(s: String): Int {
    var  sum = 0
    val map = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )
    val arr = s.toMutableList()
    for (a in  s.indices) {
        sum += if (a > 0 && map.getValue(arr[a-1]) < map.getValue(arr[a])) {
            val less = map.getValue(arr[a]) - map.getValue(arr[a-1])
            less - map.getValue(arr[a-1])
        } else {
            map.getValue(arr[a])
        }
    }
    return sum
}

//I analyze for better one
fun romanToIntAnother(s: String): Int {
    var  sum = 0
    val map = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )
    val arr = s.toMutableList()
    for (a in  s.indices) {
        val intValue = map.getValue(arr[a])
      if (a < arr.size - 1 && intValue < map.getValue(arr[a + 1])) {
            sum -= intValue
        } else {
            sum += intValue
        }
    }
    return sum
}