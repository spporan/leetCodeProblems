fun main() {
    println("titleToNumber: ${titleToNumberAnother("Z")}")
}
//
/***
 * solution like:
 *  if last char than totalNum + last char  value
 *   else:
 *    26 total alphabet * ( totalNum + current character num)
 *
 * */
fun titleToNumber(columnTitle: String): Int {
    val map = mapOf<String, Int>(
        "A" to 1,
        "B" to 2,
        "C" to 3,
        "D" to 4,
        "E" to 5,
        "F" to 6,
        "G" to 7,
        "H" to 8,
        "I" to 9,
        "J" to 10,
        "K" to 11,
        "L" to 12,
        "M" to 13,
        "N" to 14,
        "O" to 15,
        "P" to 16,
        "Q" to 17,
        "R" to 18,
        "S" to 19,
        "T" to 20,
        "U" to 21,
        "V" to 22,
        "W" to 23,
        "X" to 24,
        "Y" to 25,
        "Z" to 26
    )
    if (columnTitle.length < 2) return map.getValue(columnTitle)
    var sum = 0

    columnTitle.forEachIndexed { index, c ->
        sum = if (index == columnTitle.length - 1) {
            sum + map.getValue(c.toString())
        } else {
            26 * (sum + map.getValue(c.toString()))
        }
    }
    return sum
}

/**
 * Best approach I think
 *  firstly: find out the diff of the character
 *  diff like = char - ('A' - 1)
 *  for example: Z diff = 'Z' - ('A' - 1) = 90 - (65 - 1) = 26
 *   then calculate  sum for every char:
 *   for :
 *    sum = 26 * sum + diff
 * */
fun titleToNumberAnother(columnTitle: String): Int {
    var sum = 0
    for (char in columnTitle) {
        val diff = char - ('A' - 1)
        sum = sum * 26 + diff
        println("diff: $diff sum: $sum char ${char.code} sub ${( 'Z' - ('A' - 1))}")
    }
    return sum
}