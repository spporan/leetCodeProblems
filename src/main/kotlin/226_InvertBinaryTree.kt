import java.util.*

fun main() {
    val root = TreeNode(4)
    val t2 = TreeNode(2)
    val t3 = TreeNode(7)
    val t4 = TreeNode(1)
    val t5 = TreeNode(3)

    val t22 = TreeNode(6)
    val t23 = TreeNode(9)
    //val t24 = TreeNode(4)

    //p tree
    root.left = t2
    root.right = t3

    t2.left = t4
    t2.right = t5

    t3.left = t22
    t3.right = t23



    println("invert tree")
    printTree(invertTree(root))
}

private fun printTree(root: TreeNode?) {
    var current = root
    val queue: Queue<TreeNode> = LinkedList<TreeNode>()
    while (current != null ) {
        println(current.`val`)
        queue.add(current.left)
        queue.add(current.right)

        current = queue.remove()
    }
}

/**
 * solved 226. Invert Binary Tree
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * complexity
 *  here,
 *   n = height  of  tree
 *   time: O(n)
 *   space: O(n)
 */
fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return null
    val left = invertTree(root.left)
    val  right = invertTree(root.right)
    root.left = right
    root.right = left
    return root
}