fun main() {
    println("pascal triangle ${getRow2(2)}")

}

/**
 * solved 119. Pascal's Triangle II
 * https://leetcode.com/problems/pascals-triangle-ii/ using iterative way
 *
 * complexity:
 *  here,
 *   n = size of  the numberRows
 *   time: O(n * n) = O(n^2)
 *   space: O(n*n) = O(n^2)
 */
fun getRow(numRows: Int): List<Int> {

    val result: MutableList<MutableList<Int>> = mutableListOf()

    for (i in 0 ..   numRows) {
        val child: MutableList<Int> = mutableListOf()
        for (j in 0 ..  i) {
            if (i == 0 || j == 0 || j == i) {
                child.add(1)
            } else {
                val sum = result[i - 1][j -1] + result[i - 1][j]
                child.add(sum)
            }

        }
        result.add(child)
    }

    return result[numRows]
}
/**
 * solved 119. Pascal's Triangle II
 * https://leetcode.com/problems/pascals-triangle-ii/ using iterative way
 *
 * complexity:
 *  here,
 *   n = size of  the numberRows
 *   time: O(n * n) = O(n^2)
 *   space: O(n) = O(n)
 */
fun getRow2(numRows: Int): List<Int> {

    val ans: MutableList<Int> = ArrayList()
    ans.add(1)
    if (numRows == 0) return ans
    ans.add(1)
    if (numRows == 1) return ans

    var i = 2
    while (i <= numRows) {
        ans.add(1)
        var y = 1
        for (j in 1 until i) {
            val temp = ans[j]
            ans[j] = y + ans[j]
            y = temp
        }
        i++
    }
    return ans
}