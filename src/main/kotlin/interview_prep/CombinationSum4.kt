package interview_prep

fun main() {
    println("combinationSum4 ${combinationSum4(intArrayOf(1,2,3), 4)}")
}

/**
 * Solve this problem with bottom up approach
 * Complexity:
 *  Time : O(m * n )
 *  Space: O (n)
 */
fun combinationSum4(nums: IntArray, target: Int): Int {
    //creating a dp array size of target + 1 and initialize with 0 to store the ways to make the smallest target
    val dp = Array(target + 1) { 0 }
    //Initialize 1 at 0 index because you can make 0 only one way
    dp [0] = 1
    for (i in 1 .. target) {
        for (num in nums) {
            //checking if target is greater zero or equal and adding the count at target with calculated position
            if (i - num >= 0) {
                dp[i] += dp[i - num]
            }
        }
    }
    return dp[target]
}