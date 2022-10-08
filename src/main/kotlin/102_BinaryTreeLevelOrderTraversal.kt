fun main() {
    val t1 = TreeNode(1)
    val t2 = TreeNode(2)
    val t3 = TreeNode(3)
    val t4 = TreeNode(4)
    val t5 = TreeNode(5)
    val t6 = TreeNode(6)
    val t7 = TreeNode(7)

    t1.left = t2
    t1.right = t3
    t2.left = t4

    t2.right = t5
    t3.left = t6
    t3.right = t7
    //[1,2,3,4,n,n,5]
    println("level of tree ${levelOrder(t1)}")
}

/**
 * 102. Binary Tree Level Order Traversal
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 *
 */
fun levelOrder(root: TreeNode?): List<List<Int>> {
    if (root  == null) return emptyList()
    val res = mutableListOf(mutableListOf<Int>())
    helper(res, root, 1)
    return res
}

private fun helper(res: MutableList<MutableList<Int>> , node: TreeNode?, depth: Int) {
    if(node == null)
        return

    if (res.size == depth - 1) {
        res.add(mutableListOf(node.`val`))
    }
    else if (res.size >= depth) {
        val child = res[depth-1]
        child.add(node.`val`)
    }

    helper(res, node.left, depth + 1)
    helper(res, node.right, depth + 1)

}