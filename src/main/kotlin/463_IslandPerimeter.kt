fun main() {
    //[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]])
    println("Island Perimeter ${islandPerimeter(
        arrayOf(
            intArrayOf(1, 0),
           /* intArrayOf(1,1,1,0),
            intArrayOf(0,1,0,0),
            intArrayOf(1,1,0,0)*/
        ))
    }")
}

/**
 * 463. Island Perimeter
 * https://leetcode.com/problems/island-perimeter/
 *
 * Complexity:
 *  here,
 *   n = number of column
 *   m = number of row
 *  Time: O(n * m)
 *  Space: O(1)
 */
fun islandPerimeter(grid: Array<IntArray>): Int {
    var sumOfEdge = 0

    grid.mapIndexed { i, ints ->
        ints.mapIndexed { j, value ->
            if (value == 1) {
                val leftEdge = j -1
                val rightEdge = j + 1
                val topEdge = i - 1
                val bottomEdge = i + 1
                if (leftEdge < 0) {
                    sumOfEdge += 1
                } else if (grid[i][leftEdge]  == 0){
                    sumOfEdge += 1
                }

                if (rightEdge >= ints.size) {
                    sumOfEdge += 1
                } else if (grid[i][rightEdge] == 0) {
                    sumOfEdge += 1
                }

                if (topEdge < 0) {
                    sumOfEdge += 1
                } else if (grid[topEdge][j] == 0) {
                    sumOfEdge += 1
                }

                if (bottomEdge >= grid.size) {
                    sumOfEdge += 1
                } else if (grid[bottomEdge][j] == 0) {
                    sumOfEdge += 1
                }

            }
        }
    }

    return sumOfEdge
}