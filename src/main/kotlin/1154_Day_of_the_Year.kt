import java.util.Date

fun main() {
    println("Day of the year: ${dayOfYear("2003-03-01")} ")
}

fun dayOfYear(date: String): Int {
    val spiltDate = date.split("-")
    val currentMonth = spiltDate[1].toInt()
    val currentYear = spiltDate[0].toInt()
    val dayOfCurrentMonth = spiltDate[2].toInt()
    var totalDay = dayOfCurrentMonth
    for (i in 1 until currentMonth) {
        totalDay += getNumDayCurrentMonth(currentYear, i)
    }
    println("leap year ${getNumDayCurrentMonth(1900, 2)}")
    return totalDay
}


//1 = 31 ,2 = ??,3 = 31,4 = 30, 5 = 31,6 = 30, 7 = 31, 8 = 31, 9 = 30, 10 = 31, 11 = 30, 12 = 31
private fun getNumDayCurrentMonth(year: Int, currentMonth: Int): Int {
    return if (currentMonth < 8) {
         if (currentMonth == 2) {
             return if ( (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) 29 else 28
         }
         when(currentMonth % 2 != 0) {
            true ->  31
            false -> 30
        }
    } else {
         when(currentMonth % 2 == 0) {
            true ->  31
            false -> 30
        }
    }
}