fun main() {
    val t1 = TreeNode(2)
    val t2 = TreeNode(1)
    val t3 = TreeNode(2)
    val t4 = TreeNode(1)
    val t5 = TreeNode(2)
 /*   val t6 = TreeNode(6)
    val t7 = TreeNode(7)*/

    t1.left = t2
    t1.right = t2
    t2.left = t3

   /* t2.right = t5
    t3.left = t6
    t3.right = t7*/
    //[2,1,null,null,2,1,null,null,2]
    println("find  mode from bst ${findMode(t1).toList()}")
}
var maxValue = 1

/**
 *
 * 501. Find Mode in Binary Search Tree
 */
fun findMode(root: TreeNode?): IntArray {
    val  map = hashMapOf<Int, Int>()
    helper(map, root = root)
    val res = mutableListOf<Int>()
    map.mapKeys {
        if (map.getValue(it.key) == maxValue) {
            res.add(it.key)
        }
    }
    return res.toIntArray()
}

private fun helper(map: HashMap<Int, Int>, root: TreeNode?) {
    if (root == null) return

    if (map.contains(root.`val`)) {
        val count = map.getValue(root.`val`) + 1
        maxValue = kotlin.math.max(count, maxValue)

        map[root.`val`] = count
    } else {
        map[root.`val`] = 1
    }

    helper(map, root.left)
    helper(map, root.right)
}