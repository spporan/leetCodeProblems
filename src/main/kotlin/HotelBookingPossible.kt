fun main() {
    println("possible ${possibleHotelBooking(intArrayOf(1,3,5), intArrayOf(2,6,8), 1)}")
}
/**

A hotel manager has to process N advance bookings of rooms for the next season. His hotel has K rooms. Bookings contain an arrival date and a departure date. He wants to find out whether there are enough rooms in the hotel to satisfy the demand. Write a program that solves this problem in time O(N log N) .

Input:


First list for arrival time of booking.
Second list for departure time of booking.
Third is K which denotes count of rooms.

Output:

A boolean which tells whether it's possible to make a booking.
Return True or False.
False -> No there are not enough rooms for N booking.
True -> Yes there are enough rooms for N booking.
Example :

Input :
        Arrivals :   [1 3 5]
        Departures : [2 6 8]
        K : 1

Return : False

At day = 5, there are 2 guests in the hotel. But I have only one room.

**/

/**
 * Writing a function to know is it possible to book hotel whether not
 *
 * Note it's just a solution not the most optimized one
 */
fun possibleBooking(arrivals: IntArray, departures: IntArray, k: Int): Boolean {
    val days:MutableMap<Int, Int> = mutableMapOf()

    arrivals.zip(departures).forEach { pair ->
        for (i in pair.first .. pair.second) {
            days[i] = days.getOrDefault(i, 0) + 1
            if ( days.getOrDefault(i, 0) > k) return false
        }
    }
    return true
}

/**
 * Note possible best solution which time complexity O(n log n)
 * and space complexity O(p) where p is the total days
 */
fun possibleHotelBooking(arrivals: IntArray, departures: IntArray, k: Int):Boolean {
     arrivals.sort()
    departures.sort()

    var i = 0
    var j = 0
    var count = 0

    while (i < arrivals.size && j < departures.size) {
        if (arrivals[i] < departures[j]) {
            count += 1
            if (count > k) return false
            i++
        } else {
            count -= 1
            j++
        }
    }
    return true
}