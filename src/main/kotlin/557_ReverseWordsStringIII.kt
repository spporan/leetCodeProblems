fun main() {
    println("reverseWords ${reverseWords( "Let's take LeetCode contest")}")
}

/**
 * 557. Reverse Words in a String III
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
 *
 * Time Complexity:
 *  Time: O(n)
 *  Space: O(1)
 */
fun reverseWords(s: String): String {

  val splits =  s.split(" ")
    var reverse = ""
    splits.map { str ->
        println("word $str")
        val chars = str.toMutableList()
        var i = 0
        var j = str.length - 1
        while (i < j) {
            val temp = chars[j]
            chars[j] = chars [i]
            chars[i] = temp
            i ++
            j --
        }
        reverse += chars.joinToString("") + " "
    }
    return  reverse.trim()
}