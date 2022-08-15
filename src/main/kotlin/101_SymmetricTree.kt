fun main() {
    val root = TreeNode(1)
    val t2 = TreeNode(2)
    val t3 = TreeNode(3)
    val t4 = TreeNode(4)

    val t22 = TreeNode(2)
    val t23 = TreeNode(3)
    val t24 = TreeNode(4)

    //p tree
    root.left = t2
    root.right = t22

    t2.left = t3
    t2.right = t4

    t22.left = t24
    t22.right = t23


    println("is same tree p and q ${isSymmetric(root)}")

}

/**
 * @link 101. symmetric Tree problem: https://leetcode.com/problems/symmetric-tree/
 * Solved using brute force approach
 *
 * Complexity of the problem:
 *  here,
 *   n = size of the node
 *  time: O(n)
 *  space: O(n)
 */

fun isSymmetric(root: TreeNode?): Boolean {
    return isSymmetric(root, root)
}

private fun isSymmetric(leftNode: TreeNode?, rightNode: TreeNode?): Boolean {

    if (leftNode == null && rightNode == null) return true

    if (leftNode?.`val` != rightNode?.`val`) return false

    return isSymmetric(leftNode?.left, rightNode?.right) && isSymmetric(leftNode?.right, rightNode?.left)
}
