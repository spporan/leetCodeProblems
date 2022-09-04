fun main() {
    val t1 = TreeNode(1)
    val t2 = TreeNode(2)
    val t3 = TreeNode(3)
    val t4 = TreeNode(5)
    val t5 = TreeNode(6)

    //p tree
    t1.left = t2
    t1.right = t3


    t2.right = t4
    t2.left = t5

    println("is same tree p and q ${binaryTreePaths(t1)}")
}

/**
 * solved 257. Binary tree path
 * https://leetcode.com/problems/binary-tree-paths/
 *
 * Complexity
 *   n = number of the node
 *  Time: O(n)
 *  Space: O(n)
 *
 *  output: ["1->2->5","1->3"]
 */
fun binaryTreePaths(root: TreeNode?): List<String> {
    val result: MutableList<String> = mutableListOf()
    helper(root, result)
    return result
}

private fun helper(root: TreeNode?, result: MutableList<String>, path: String = "") {
   if (isLeafNode(root)) {
       result.add(path + root?.`val`)
       return
   }

    if (root?.left != null) {
        helper(root.left, result, path + root.`val` + "->")
    }

    if (root?.right != null) {
        helper(root.right, result, path + root.`val` + "->")
    }
}

private fun isLeafNode(root: TreeNode?) = root != null && root.left == null && root.right == null