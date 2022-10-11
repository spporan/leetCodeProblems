import kotlin.math.abs

fun main() {
    val t1 = TreeNode(4)
    val t2 = TreeNode(2)
    val t3 = TreeNode(9)
    val t4 = TreeNode(3)
    val t5 = TreeNode(5)
    val t6 = TreeNode(7)

    val t7 = TreeNode(7)
    //[4,2,9,3,5,null,7]
    t1.left = t2
    t1.right = t3

    t2.left = t4
    t2.right = t5

    t3.right = t6

    println("findTilt ${findTilt(t1)}")
}

fun findTilt(root: TreeNode?): Int {
    helper(root)
    return res
}

var res = 0
private fun helper(root: TreeNode?): Int {
    if (root == null) return 0

    val l = helper(root.left)
    val r = helper(root.right)
    res += abs(l-r)

    return l + r +  root.`val`
}
