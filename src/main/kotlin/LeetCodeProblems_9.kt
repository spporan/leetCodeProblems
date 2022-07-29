fun main(args: Array<String>) {
    println("Hello World!")

    println("isPalindrome ${isPalindrome(123)}")
    println("isPalindrome1 ${isPalindrome1(121)}")


}

//using builtin function in kotlin solved the problem
fun isPalindrome(x: Int): Boolean {
    return x.toString().reversed() == x.toString()
}

// solved problem using basic loop
fun isPalindrome1(x: Int): Boolean {
    var reverseString: String = ""
    val xStr = x.toString()
    for( i in xStr.lastIndex downTo 0) {
        reverseString += xStr[i]
    }
    return xStr == reverseString
}