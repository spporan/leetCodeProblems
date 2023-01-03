fun main() {
    val ti = TreeNode(5)
    val l1 = TreeNode(3)
    val r1 = TreeNode(1)

    ti.left = l1
    ti.right = r1

    println("root equal to the sum of two child: ${checkTree(ti)}")
}

fun checkTree(root: TreeNode?): Boolean {
    val rootVal = root?.`val`
    val sum = (root?.left?.`val` ?: 0) + (root?.right?.`val` ?: 0)
    return rootVal == sum
}
