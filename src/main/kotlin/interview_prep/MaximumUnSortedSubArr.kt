package interview_prep

fun main() {
    println("sorted array ${unSortSubArray(intArrayOf(5,6,1,2,4,7)).toList()}")
}

private fun sort(arr: IntArray): IntArray {
    val n = arr.size
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            if (arr[i] > arr[j]) {
                val temp = arr[i]
                arr[i] = arr[j]
                arr[j] = temp
            }
        }
    }
    return arr
}

/**
 * This solution is not optimized.
 * It's a simple solution, firstly copy the array and sort the array and run a loop to get
 * a starting index where sorted array's item greater than copy item and mark this index as a start
 * index
 * and run another loop to find end index of the last match item where copyArr items grater or equal sort items
 *
 * it's time complexity O(n log n)
 */
private fun subUnSortArr(arr: IntArray): IntArray {
    val copyArr = arr.copyOf()
    val sortArr = sort(arr)
    var start = 0
    var  end = copyArr.size-1
    for (i in copyArr.indices) {
        if (copyArr[i] <= sortArr[i]) {
            start++
        } else {
            break
        }
    }

    if (start == copyArr.size) return intArrayOf(-1)

    for (i in copyArr.size-1 downTo 0) {
        if (copyArr[i] >= sortArr[i]) {
            end--
        } else {
            break
        }
    }
    return intArrayOf(start,end)
}

private fun unSortSubArray(arr: IntArray): IntArray {
    val n = arr.size
    var min = 0
    var max = 0
    var start = 0
    var end = 0

    for (i in 0 until n-1) {
        if (arr[i] > arr[i+1]) break
        start++
    }

    if (start == n-1) return intArrayOf(-1)

    for (i in n-1 downTo  start + 1) {
        if (arr[i] < arr[i-1] || arr[i] < arr[start]) break
        end = i
    }

    min = arr[start]
    max = arr[end]

    for (i in start .. end) {
        if (arr[i] < min) {
            min = arr[i]
        }
        if (arr[i] > max) {
            max = arr[i]
        }
     }

    for (i in 0 until start) {
        if (arr[i] > min) {
            start = i
            break
        }
    }

    for (i in n-1 downTo  end + 1) {
        if (arr[i] < max) {
            end = i
            break
        }
    }
    return intArrayOf(start,end)

 }