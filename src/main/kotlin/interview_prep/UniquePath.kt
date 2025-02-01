package interview_prep

fun main() {
    println("Unique path ${findUniquePathRecur(3,2)}")
}

/**
 * Solved using dp approach or bottom up approach
 * Complexity:
 *  Time: O(m * n)
 *  Space: O(m * n)
 */
fun uniquePaths(m: Int, n: Int): Int {
    val grid = Array(m) { _ -> Array(n) { _ -> 1 } }

    for (i in 1 until m) {
        for (j in 1 until n) {
            grid[i][j] = grid[i - 1][j] + grid[i][j-1]
        }
    }
    return grid[m-1][n-1]
}

/**
 * Solved using top-down approach
 * Complexity:
 *  Time: O(m * n)
 *  Space: O(m + n)
 */

fun uniquePaths1(m: Int, n: Int): Int {
    val memo = Array(m) { _ -> Array(n) { _ -> -1 } }

    return uniquePathsRecursive(0,0, m, n, memo)
}

fun uniquePathsRecursive(x: Int, y: Int, m: Int, n: Int, memo:Array<Array<Int>>): Int {

    //If we reach the destination (bottom right corner) return 1
    if (x == m-1 && y == n-1) return 1

    //checking and return calculated if there is calculated path
    if (memo[x][y] != -1) return memo[x][y]


    var rightPath = 0
    var bottomPath = 0

    //Checking if it's valid to move right
    if (x < m - 1) {
        rightPath = uniquePathsRecursive(x + 1, y, m, n, memo)
    }

    //Checking if it's valid to go down
    if (y < n - 1) {
        bottomPath = uniquePathsRecursive(x, y + 1, m, n, memo)
    }
    //Storing the ways to get the destination
    memo[x][y] = rightPath + bottomPath
    return memo[x][y]

}

/**
 * Solved using recursive approach
 * Complexity:
 * Time: O(2^(m + n)
 * Space: O (m + n)
 */
fun findUniquePathRecur(m: Int, n: Int): Int {
    if (m == 1 || n == 1) return 1
    return findUniquePathRecur(m -1, n) + findUniquePathRecur(m, n-1)
}