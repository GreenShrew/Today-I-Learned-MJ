package days02

fun main(){
    // 월과 일을 입력받아 요일을 출력한다.
    // 2022년에 한해서 입력한다.
    // 2022년 1월 1일은 토요일이다. 상대적 위치의 값으로 요일을 선택한다.

    print("월 입력 : ")
    val month:Int = readLine()!!.toInt()
    print("일 입력 : ")
    val day:Int = readLine()!!.toInt()

    var days:Int = sumdays(month)   // 1월부터 입력한 월의 전달까지 날짜수 계산하는 함수 제작
    days += day
    val temp:Int = days % 7

    val weekday:String = selectWeekday(temp) // 총 날짜를 7로 나눈 나머지를 계산하는함수 제작
    print(weekday)
}

fun sumdays(a1:Int) = when(a1){
    1->0
    2->31
    3->31+28
    4->31+28+31
    5->31+28+31+30
    6->31+28+31+30+31
    7->31+28+31+30+31+30
    8->31+28+31+30+31+30+31
    9->31+28+31+30+31+30+31+31
    10->31+28+31+30+31+30+31+31+30
    11->31+28+31+30+31+30+31+31+30+31
    12->31+28+31+30+31+30+31+31+30+31+30
    else->0
}


fun selectWeekday(a1:Int) = when(a1){
    1->"토요일"
    2->"일요일"
    3->"월요일"
    4->"화요일"
    5->"수요일"
    6->"목요일"
    0->"금요일"
    else->"잘못된 연산입니다."
}