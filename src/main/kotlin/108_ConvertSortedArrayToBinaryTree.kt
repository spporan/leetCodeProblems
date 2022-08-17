fun main() {
    println("BST <><><><><><>")
    val  bst = sortedArrayToBST(intArrayOf(-10, -3, 0, 5, 9))
    preOrder(bst)
}

fun preOrder(node: TreeNode?) {
    if (node == null) {
        return
    }
    print("${node.`val`} " )
    preOrder(node.left)
    preOrder(node.right)
}

/**
 * Solved
 * 108. Convert Sorted Array to Binary Search Tree
 * @link https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * Complexity:
 *  here,
 *   n = size of the sorted array
 *   h =  height of the tree
 *   time: O(n)
 *   space: O(h) for recursion call stack
 */
fun sortedArrayToBST(nums: IntArray): TreeNode? {
    return sortedArrayToBST(nums, 0, nums.size - 1)
}

fun sortedArrayToBST(nums: IntArray, startIndex: Int, endIndex: Int): TreeNode? {

    if (startIndex > endIndex)  return null

    val midIndex: Int = (startIndex + endIndex) / 2

    val node = TreeNode(nums[midIndex])

    node.left = sortedArrayToBST(nums, startIndex, midIndex -1)

    node.right = sortedArrayToBST(nums, midIndex + 1,  endIndex)

    return node
}