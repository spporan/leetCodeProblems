package interview_prep

import java.util.Objects

/*fun main() {
    println("majorityElement ${majorityElement2(intArrayOf(3,3,4))}")
}*/

/**
 * linear time complexity
 * space O(n)
 */
fun majorityElement(nums: IntArray): Int {
    val memo: MutableMap<Int, Int> = mutableMapOf<Int, Int>()

    nums.forEach { num ->
        if (memo.containsKey(num)) {
            memo[num] = memo.getValue(num) + 1
        } else {
            memo[num] = 1
        }
    }
    var maxCount = Int.MIN_VALUE
    var maxItem = 0
    memo.keys.map {key ->
        if (maxCount < memo.getValue(key)) {
            maxCount = memo.getValue(key)
            maxItem = key
        }
    }
    return maxItem
}


/**
 * linear time complexity
 * space O(1)
 */
fun majorityElement2(nums: IntArray): Int {

    var maxCount = 0
    var maxItem = 0
    nums.forEach { num ->
        if (maxCount == 0) {
            maxItem = num
        }
        if (maxItem == num) {
            maxCount += 1
        } else {
            maxCount -= 1
        }
    }
    return maxItem
}

fun main(args: Array<String>) {
    val a =  A
    val printable: Printable = A
    a.isPossible()


}

interface Loggable {
    fun log()
}

interface Printable {
    fun print()
}

open class E {
    val TAG = "E"
    fun isPossible (): Boolean {
        println("isPossible ..")
        return true
    }
    init {
        println("class of E")
    }
}

class A {
    init {
        object {
            val v = "anonymous"
            init {
                println("anim")
            }
        }

        val c = "We"


    }

    private val m = "private"
    companion object B: Printable, Loggable, E () {

        object C {
            init {
                println("object of C ")
            }

            fun c() {
                println("C")

            }
        }

        init {
            println("companion of B ")
        }

        override fun print() {
            println("print ")
        }

        override fun log() {
            println("print")
        }

    }
}


