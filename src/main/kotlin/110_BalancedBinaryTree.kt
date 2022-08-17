import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main() {
    val root = TreeNode(1)
    val n2 = TreeNode(9)
    val n3 = TreeNode(20)
    val n4 = TreeNode(15)
    val n5 = TreeNode(7)
    val n6 = TreeNode(15)
    val n7 = TreeNode(7)

    root.left = n2
    root.right = n3

    n2.left = n4
    n2.right = n5

    n4.left = n6
    n4.right = n7

    println("isBalanced tree ${isBalanced(root)}")
}

fun isBalanced(root: TreeNode?): Boolean {

    if (root == null) return true

    if (isMaxDepth(root) == -1) return false

    return true
}

/**
 * Solved 110. Balanced Binary Tree
 * @link https://leetcode.com/problems/balanced-binary-tree/
 *
 * Complexity:
 *  n = number of the nodes
 *  h = depth of the tree
 *
 *  time: O(n)
 *  space: O(h)
 */
private fun isMaxDepth(root: TreeNode?): Int {
    if (root == null) return 0

    val left = isMaxDepth(root.left)

    val right = isMaxDepth(root.right)

    println(" left $left right $right")

    if (left == -1 || right == -1) return -1

    if (abs(left - right) > 1) return -1

    return 1 + max(left, right)

}


