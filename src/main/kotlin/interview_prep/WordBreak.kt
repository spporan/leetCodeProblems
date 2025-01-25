package interview_prep

fun main() {
    println("wordBreak ${wordBreak( "catsanddog", wordDict = listOf("cats","dog","sand","and","cat"))}")
}


/**
 * Solved this WordBreak problem
 * Complexity:
 *  Time: O(m * n)
 *  Space: O(n)
 */
fun wordBreak(s: String, wordDict: List<String>): Boolean {
    val n = s.length
    //Creating a dp array size of string length + 1 to keep track the word found in the dict
    val dp = Array(n + 1) {false}
    //set at 0 index to true because empty string to be considered as true
    dp[0] = true
    for (i in 1 ..n) {
        for (j in 0 until i) {
            val sub = s.substring(j, i)
            //checking the substring to be found in dict and previous word is found
            if (dp[j] && wordDict.contains(sub)) {
                dp[i] = true
                //braking the loop if found the word in the dict. No need to check smaller sub string
                break
            }
        }
    }
    return dp[n]
}
