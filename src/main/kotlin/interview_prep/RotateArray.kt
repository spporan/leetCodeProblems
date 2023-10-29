package interview_prep

fun main() {
    println("rotate ${rotate(intArrayOf(1,2,3,4,5,6,7), 3)}")

}

fun rotate(nums: IntArray, k: Int): Unit {
    val k  = k % nums.size
    reverse(nums, 0, nums.size - 1)

    reverse(nums, 0, k - 1)

    reverse(nums, k , nums.size - 1)

}

private fun reverse(nums: IntArray, start: Int, end: Int) {
    var startIndx = start
    var endIndx = end

    while (startIndx < endIndx) {
        val temp = nums[startIndx]
        nums[startIndx] = nums[endIndx]
        nums[endIndx] = temp
        startIndx ++
        endIndx --
    }
}

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF);

    fun someMethod(): Int {
        return rgb
    }
}

enum class PaymentOption {
    CASH {
        override fun startPayment(
            transaction: Int
        ) {
            println()
        }
    },
    CARD {
        override fun startPayment(
            transaction: Int
        ) {

        }
    },
    TRANSFER {
        override fun startPayment(
            transaction: Int
        ) {

        }
    };

    abstract fun startPayment(transaction: Int)
}

enum class PaymentOptions(
    val startPayment: (String) -> Unit
) {
    CASH(::println),
    CARD(::println),
    TRANSFER({
        println("print something here")
    })
}

sealed class Face
