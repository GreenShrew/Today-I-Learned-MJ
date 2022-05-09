package days02

fun main(){
    // 코틀린에서 사용하는 자바의 switch 에 해당하는 문법이다.
    val a1 = 10
    when(a1){
        1 -> println("a1은 1입니다.")
        2 -> {
            println("수행되는 코드")
            println("a1은 2입니다.")
        }
        3 -> println("a1은 3입니다.")
        else -> println("a1은 1, 2, 3이 아닙니다.")
    }
    // switch case와 비슷한 문법이다. 각 case를 -> 로 표시한다. break를 쓰지 않아도 된다.


    val a2 = 3
    when(a2){
        1, 2 -> println("a2는 1이거나 2입니다.")
        3, 4 -> println("a2는 3이거나 4입니다.")
        5, 6 -> println("a2는 5이거나 5입니다.")
        else -> println("a2는 1, 2, 3, 4, 5, 6이 아닙니다.")
    }   // (,) 컴마로 구분하여 두가지 경우롤 하나의 case로 처리할 수 있다.

    val a5 = 5
    when(a5){
        in 1..3 -> println("a5는 1~3 사이의 숫자입니다.")
        in 4..6 -> println("a5는 4~6 사이의 숫자입니다.")
        in 1..6 -> println("a5는 1~6 사이의 숫자입니다.")
        else -> println("a2는 1~6 사이의 숫자가 아닙니다.")
    }   // in 키워드와 .. 연산자를 이용하여 범위를 골라는 case를 제작할 수 있다.

    // var a6:String = if(a5==5) "5입니다." else "5가 아닙니다."

    val a6 = 20
    val str:String = when(a6){
        10->"10입니다."
        20->{
            println("두번째 경우의 수")
            "20입니다."
        }
        30->"30입니다."
        else->"10~30이 아닙니다."
    }   // 각 케이스에서 선택된 값을 결과로 반환하여 변수의 값으로 활용할 수 있다.
    println("str : $str")

    val str1 = setValue(10)
    val str2 = setValue(20)
    val str3 = setValue(30)
    println("str1 : $str1")
    println("str2 : $str2")
    println("str3 : $str3")
}

fun setValue(a1:Int) = when(a1){
    10->"10입니다."
    20->"20입니다."
    30->"30입니다."
    else->"10~30이 아닙니다."
}   // 함수의 몸체가 when으로 대체되어 선택된 데이터가 함수의 리턴값으로 사용된다.
// 원래라면 아래처럼 만들어야한다.
/*
fun setValue(a1:Int) : String{
    val str:String = when(a1){
        10->"10입니다."
        20->"20입니다."
        30->"30입니다."
        else->"10~30이 아닙니다."
    }
    return str
}
 */