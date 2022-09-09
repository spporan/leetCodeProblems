fun main() {
    val root = TreeNode(3)
    val t2 = TreeNode(9)
    val t3 = TreeNode(20)
    val t4 = TreeNode(15)
    val t5 = TreeNode(7)

    root.left = t2
    root.right = t3
    t3.left = t4
    t3.right = t5

    println("Sum of left leaf  node: ${sumOfLeftLeaves(root)}")
}


/**
 * Solved
 * 404. Sum of Left Leaves
 * https://leetcode.com/problems/sum-of-left-leaves/
 *
 * Complexity:
 *   Time: O(n)
 *   Space: O(n)
 *
 */
fun sumOfLeftLeaves(root: TreeNode?): Int {
    if (isLeafNode(root)) return 0


    return sumOfLeftLeaves1(root)
}

private fun sumOfLeftLeaves1(root: TreeNode?, isLeft: Boolean = false ):Int {
    if (root == null) return 0

    if (isLeafNode(root) && isLeft) {
        return root.`val`
    }
    return sumOfLeftLeaves1(root.left, true) + sumOfLeftLeaves1(root.right, false)
}

private fun isLeafNode(node: TreeNode?) = node != null && node.left == null && node.right == null