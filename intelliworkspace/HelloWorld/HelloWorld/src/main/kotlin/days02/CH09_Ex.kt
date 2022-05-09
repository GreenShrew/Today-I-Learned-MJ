package days02

fun main(){
    print("연도 입력 : ")
    val year:Int = readLine()!!.toInt()
    print("월 입력 : ")
    val month:Int = readLine()!!.toInt()
    print("일 입력 : ")
    val day:Int = readLine()!!.toInt()

    var days:Int = sumdays(year, month, day)   // 전달인수에 year, day도 추가
    // sumdays 함수 안에서 월에 해당하는 날짜수 계산할때 when을 이용하지 않고, 배열 생성후 반복 실행과 함께 계산하자.
    val temp:Int = days % 7
    val weekday:String = selectWeekday(temp) // 총 날짜를 7로 나눈 나머지를 계산하는함수 제작
    print(weekday)
}


fun sumdays(a1:Int, a2:Int, a3:Int) : Int{
    var day:IntRange = 1..(a1-1)
    var total = 0;

    for(item in day){
        if(item%4 == 0 || item%100 != 0 || item%400 == 0){
            total += 366
        }else{
            total += 365
        }
    }

    var month = Array(12,{0})
    if(a1%4 == 0 || a1%100 != 0 || a1%400 == 0){
        month = arrayOf(0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30)
    }else{
        month = arrayOf(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30)
    }

    var i:Int = 0;
    while(i<a2){
        total += month[i]
    }


    return 10;
}