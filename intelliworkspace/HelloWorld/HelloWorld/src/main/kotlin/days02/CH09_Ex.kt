package days02

// CH09_Ex

fun main(){

    print("연도 입력 : ")
    val year:Int = readLine()!!.toInt()
    print("월 입력 : ")
    val month:Int = readLine()!!.toInt()
    print("일 입력 : ")
    val day:Int = readLine()!!.toInt()

    var days:Int = sumdays(year, month, day)  // 전달인수에 year, day 도 추가
    // sumdays 함수안에서 월에 해당하는 날짜수 계산할때 when 을 이용하지 말고, 배열생성후 반복실행과 함께 계산해주세요
    val temp:Int = days % 7
    val weekday:String = selectWeekday2(temp)
    println(weekday)

}


fun sumdays( y:Int, m:Int, d:Int) : Int{
    var days:Int = 0
    var mdays = arrayOf(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31) // 배열생성
    if( y%4==0 && y%100!=0 || y%400==0 ) mdays[2] = 29   // 입력한 년도가 윤년이면 2월을 29일로 변경
    days = 365*(y-1)
    val ys:IntRange = 1..(y-1)
    for( i in ys){
        if( i%4==0 && i%100!=0 || i%400==0) days++
    } // 입력한 년도의 전년도까지 있었던 윤년 만큼 +1 반복
    var i:Int = 0
    while( i<m ){
        days += mdays[i]
        i++
    } // 입력한 월의 전월까지 날짜 합산

    days += d  // 입력한 일만큼 날짜 합산
    return days
}

fun selectWeekday2( t:Int ) : String = when(t) {
        1 -> "월요일입니다"
        2 -> "화요일입니다"
        3 -> "수요일입니다"
        4 -> "목요일입니다"
        5 -> "금요일입니다"
        6 -> "토요일입니다"
        0 -> "일요일입니다"
        else -> "잘못된 연산입니다"
}