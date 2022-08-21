fun main() {
  println("pascal triangle ${generate(2)}")
}

/**
 * solved 118. Pascal's Triangle
 * https://leetcode.com/problems/pascals-triangle/ using iterative way
 *
 * complexity:
 *  here,
 *   n = size of  the numberRows
 *   time: O(n * n) = O(n^2)
 *   space: O(n*n) = O(n^2)
 */


fun generate(numRows: Int): List<List<Int>> {

    val result: MutableList<MutableList<Int>> = mutableListOf()

    for (i in 0 until   numRows) {
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
  return result
}