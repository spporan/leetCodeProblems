/**
 * @link of the problem https://leetcode.com/problems/palindrome-number/
 */
fun main(args: Array<String>) {
    println("Hello World!")

    println("isPalindrome ${isPalindrome(123)}")
    println("isPalindrome1 ${isPalindrome1(12321)}")

    println("isPalindromeWithoutConvertString ${isPalindromeWithoutConvertString(12321)}")

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


//optimize solution for check palindrome number
fun isPalindromeWithoutConvertString(x: Int): Boolean {
    // If x is a negative number it is not a palindrome
    // If x % 10 = 0, in order for it to be a palindrome the first digit should also be 0
    if (x < 0 || (x != 0 && x%10 == 0))  return false

    var  reverseNum = 0
    var xTemp = x

    while (xTemp > reverseNum) {
        reverseNum = reverseNum * 10 + (xTemp % 10) //xTemp =  123 reverseNum = 0 * 10 + (123 % 10) = 0 + 3
        xTemp /= 10
    }
    // If x is equal to reversed number then it is a palindrome
    // If x has odd number of digits, dicard the middle digit before comparing with x
    // Example, if x = 23132, at the end of for loop x = 23 and reversedNum = 231
    // So, reversedNum/10 = 23, which is equal to x
    return xTemp == reverseNum || (reverseNum / 10 == xTemp)
}
