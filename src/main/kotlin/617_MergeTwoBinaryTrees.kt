fun main() {
    val root1 = TreeNode(1)
    val t2 = TreeNode(3)
    val t3 = TreeNode(2)
    val t4 = TreeNode(5)

    root1.left = t2
    root1.right = t3
    t2.left = t4

    val root2 = TreeNode(2)
    val t12 = TreeNode(1)
    val t13 = TreeNode(3)
    val t14 = TreeNode(4)
    val t15 = TreeNode(7)

    root2.left = t12
    root2.right = t13
    t12.right = t14
    t13.right = t15
    //Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
    //Output: [3,4,5,5,4,null,7]
    printTree(mergeTrees(root1, root2))
}

/**
 *  617. Merge Two Binary Trees
 *  https://leetcode.com/problems/interview_prep.merge-two-binary-trees/
 *
 *  Complexity:
 *   n = minimum number of the nodes in tree
 *   h = depth of the tree
 *  Time: O(n)
 *   space: O(h)
 */
fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
    if (root1 == null && root2 == null) return null

    val value = (root1?.`val` ?: 0 ) + (root2?.`val` ?: 0)
    val node = TreeNode(value)
    node.left = mergeTrees(root1?.left, root2?.left)
    node.right = mergeTrees(root1?.right, root2?.right)
    return node
}