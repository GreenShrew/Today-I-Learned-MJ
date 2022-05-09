package days02

fun main(){
    // 기본 if문
    val a1:Int = 10
    if(a1 == 10) println("a1은 10입니다.")
    if(a1 != 10) {
        println("a1은 10이 아닙니다.")
    }
    println("----------------------------------")
    // else문 : 조건식이 만족하지 않을 경우 수행될 부분
    if(a1 == 10) println("a1은 10입니다.")
    else println("a1은 10이 아닙니다.")

    if(a1 == 20){
        println("a1은 20입니다.")
    }else{
        println("a1은 20이 아닙니다.")
    }
    println("----------------------------------")
    // else if
    if(a1 == 5){
        println("a1은 5입니다")
    }else if(a1 == 10){
        println("a1은 10입니다")
    }else{
        println("a1은 5, 10이 아닙니다.")
    }
    println("----------------------------------")

    var a4:String = ""
    val a5:Int = 10

    // 자바와 코틀린이 같아지는 if문의 사용
    if(a5 == 10) a4 = "10입니다."
    else a4 = "10이 아닙니다."
    println("a4 : $a4")

    // 자바에서만 사용하는 if문의 변형사용법이다!
    /*
    var b:Int = 10
    var a6 = (b!=10)? "10과 같습니다." : "10과 같지 않습니다.";
     */
    
    // 코틀린에서만 사용할 수 있는 if문의 변형 사용
    // 변수에 내용을 저장하기!
    val a6:String = if(a5==10) "10입니다." else "10이 아닙니다."
    println("a6 : $a6")

    // 무언가를 출력도 하고, 변수(a7)에 값을 입력하는 동작을 동시에!
    val a7:String = if(a5 == 10){
        println("블록 1 수행")
        "10 입니다."       // 변수에 입력될 값은 각 경에 해당하는 영역 맨 마지막에 써준다.
    }else{
        println("블록 2 수행")
        "10이 아닙니다."
    }
    println("a7 : $a7")


}