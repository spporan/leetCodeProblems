import kotlin.math.max
import kotlin.math.min

fun main() {
    //[2,null,3,null,4,null,5,null,6]
    val root = TreeNode(2)
    val t2 = TreeNode(3)
    val t3 = TreeNode(4)
    val t4 = TreeNode(5)
    val t5 = TreeNode(6)

    root.right = t2
    t2.right = t3
    t3.right = t4
    t4.right =  t5
    println("min depth of tree ${minDepth(root)}")
}

/**
 * Solved problem 111. Minimum Depth of Binary Tree https://leetcode.com/problems/minimum-depth-of-binary-tree/
 *
 * Complexity of minimum  depth of tree
 *  here, n = number of nodes
 *  time: O(n)
 *  space: O(n)
 *
 *
 */
fun minDepth(root: TreeNode?): Int {
    if (root == null) return 0

    val leftDepth = minDepth(root.left)
    val right = minDepth(root.right)

    return if (leftDepth == 0 || right == 0)
        1 + max(leftDepth, right)
    else
        1 + min(leftDepth, right)
}