fun main() {
    val root = TreeNode(1)
    val t2 = TreeNode(9)
    val t3 = TreeNode(2)
    val t4 = TreeNode(15)
    val t5 = TreeNode(7)

    //root.left = t2
    root.right = t3
    //t3.left = t4
   // t3.right = t5
    println("max depth of tree ${maxDepth(root)}")
}

/**
 * @link of Maximum Depth of Binary Tree https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 * Complexity of Maximum  depth of tree
 *  here, n = number of nodes
 *  time: O(n)
 *  space: O(n)
 *
 *
 */
fun maxDepth(root: TreeNode?): Int {
    if (root == null) return 0


    val leftTreeDepth = 1 + maxDepth(root.left)

    val rightTreDepth = 1 + maxDepth(root.right)

    return if (leftTreeDepth > rightTreDepth)
        leftTreeDepth
    else {
        rightTreDepth
    }

}