
import kotlin.math.max

fun main() {
    println("version check ${compareVersion("1.0.1",
        "1")}")
}

/**
 * Solved
 * 165. Compare Version Numbers
 * https://leetcode.com/problems/compare-version-numbers/submissions/
 *
 * Complexity:
 *  Time: O(n)
 *  Space: O(n)
 */
fun compareVersion(version1: String, version2: String): Int {

    val versionArr1 = version1.split(".")
    val versionArr2 = version2.split(".")

    val maxSize = max(versionArr1.size, versionArr2.size)
    for (i in 0 until maxSize) {
        val versionNum1 = if (i < versionArr1.size) versionArr1[i].toInt() else 0
        val versionNum2 = if (i < versionArr2.size) versionArr2[i].toInt() else 0
        val comp = versionNum1.compareTo(versionNum2)
        if (comp != 0) {
            return comp
        }

    }
    return 0
}