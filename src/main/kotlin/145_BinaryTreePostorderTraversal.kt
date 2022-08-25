import java.util.Stack

fun main() {
    val root = TreeNode(3)
    val n2 = TreeNode(1)
    val n3 = TreeNode(2)
    root.left = n2
    root.right = n3

    /*val n4 = TreeNode(15)
    val n5 = TreeNode(7)
    val n6 = TreeNode(15)
    val n7 = TreeNode(7)*/
    println("res ${postorderTraversal(root)}")
    println("res1 ${postorderTraversalUsingIteratively(root)}")

}

/** Solved
 *  145. Binary Tree Postorder Traversal
 *  https://leetcode.com/problems/binary-tree-postorder-traversal/
 *
 *  Complexity:
 *   here,
 *     n = depth of the tree
 *
 *     time: O(n)
 *     space: O(n)
 */
fun postorderTraversal(root: TreeNode?): List<Int> {
    println("val <> ${root?.`val`}")
    if (root == null) return emptyList()

    return  postorderTraversal(root.left) +  postorderTraversal(root.right) + listOf(root.`val`)
}

fun postorderTraversalUsingIteratively(root: TreeNode?): List<Int> {
    var currentNode: TreeNode? = root

    val stack: Stack<TreeNode?> = Stack<TreeNode?>()
    val result = mutableListOf<Int>()
    while (!stack.empty() || currentNode != null) {

        if (currentNode?.left != null) {
            stack.push(currentNode)
            currentNode = currentNode.left
        }
        else if (currentNode?.right != null) {
            stack.push(currentNode)
            currentNode = currentNode.right
        }
        else {
            if (currentNode != null) {
                stack.push(currentNode)
                //currentNode = currentNode
            }
            val p = stack.pop()

            p?.let { result.add(it.`val`) }
            currentNode = stack.pop()

        }

    }
    return result
}