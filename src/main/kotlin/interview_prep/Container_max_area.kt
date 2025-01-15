package interview_prep

fun main() {
    println("Max area ${maxArea(intArrayOf(1,1))}")
}

fun maxArea(height: IntArray): Int {
    var left = 0
    var right = height.size - 1
    var maxArea = Int.MIN_VALUE

    while (left < right) {
        var area = 0
        //println("l $left r $right")
        if (height[left] <= height[right]) {
            area = height[left] * (right - left)
            if (area > maxArea) {
                maxArea = area
            }
            //("## item ${height[left]} item $right area # $area")
            left++
        }
        else if (height[left] > height[right]) {
            area = height[right] * (right - left)
            if (area > maxArea) {
                maxArea = area
            }
            //println(" <<>>> item ${height[right]} item ${(right - left)} area # $area")

            right--
        }
    }
    return maxArea

}