fun main() {
    val t1 = TreeNode(1)
    val t2 = TreeNode(2)
    val t3 = TreeNode(3)

    val t21 = TreeNode(1)
    val t22 = TreeNode(2)
    val t23 = TreeNode(3)

    //p tree
    t1.left = t2
    //t1.right = t3

    //q tree
    //t21.left = t22
    t21.right = t22

    println("is same tree p and q ${isSameTree(t1, t21)}")

}

/**
 * @link 100. Same Tree problem: https://leetcode.com/problems/same-tree/
 * Solved using brute force approach
 *
 * Complexity of the problem:
 *  here,
 *   n = size of the node
 *  time: O(n)
 *  space: O(n)
 */

private fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {

    if (p == null && q == null) return true

    if (p?.`val` != q?.`val`) return false

    return isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
}

 class TreeNode(var `val`: Int) {
      var left: TreeNode? = null
      var right: TreeNode? = null
 }

