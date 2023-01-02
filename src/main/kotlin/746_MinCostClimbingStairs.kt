

fun main() {
    println("min cost ${minCostClimbingStairs(intArrayOf(1,100,1,1,1,100,1,1,100,1))}")
}

fun minCostClimbingStairs(cost: IntArray): Int {
    val num = cost.size
    // recursive solution
    //return kotlin.math.min(minCostClimb(num, cost, 0), minCostClimb(num, cost, 1))
    val memo = IntArray(num + 1) { -1 }
    return kotlin.math.min(minCostClimbWithMemo(memo, num, cost, 0), minCostClimbWithMemo(memo, num, cost, 1))
}

//recursion approach time limit exceeded
private fun minCostClimb(n: Int, cost: IntArray, index: Int): Int {
    if (index >= n) return 0

    val oneStep = minCostClimb(n, cost, index + 1)
    val twoStep = minCostClimb(n, cost, index + 2)

    return cost[index] + kotlin.math.min(
        oneStep,
        twoStep
    )
}

//solution using memorization technique
// dp solution
private fun minCostClimbWithMemo(memo:IntArray, n: Int, cost: IntArray, index: Int): Int {
    if (index >= n) return 0

    if (memo[index] != -1) return memo[index]
    val oneStep = minCostClimbWithMemo(memo, n, cost, index + 1)
    val twoStep = minCostClimbWithMemo(memo, n, cost, index + 2)
    val minTop = cost[index]+ kotlin.math.min(oneStep,twoStep)
    memo[index] = minTop
    return minTop
}