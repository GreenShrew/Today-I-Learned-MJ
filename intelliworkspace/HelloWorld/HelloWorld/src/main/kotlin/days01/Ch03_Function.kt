package days01

fun main() {
    // 함수를 만드는 문법
    // fun 함수이름(매개변수) : 리턴값의 타입{
    //    코드들....
    // }
    // 함수는 메인함수의 외부에도, 내부에도 생성이 가능합니다.
    // 변수에 지역변수와 전역변수가 존재하듯, 함수도 그렇다는 뜻입니다
    test1()
    val a3:Int = 200

    test2( 20 , 12.23 )  //test2() 함수 호출
    // 매개변수가 있는 함수를 호출할때, 전달인수를 넣는 동작이 하나하나 끝날때 마다 '매개변수 이름 :' 를 인텔리제이가 전달인수 앞에 붙여줍니다.
    // 자동으로 입력되는 사항이니, 수동으로 입력하지 않아도 됩니다.
    val k1:Int = 20
    val k2:Double = 123.45
    test2(k1, k2)  // 변수가 전달인수로 전달될 때는 앞에 매개변수 이름이 붙지 않습니다.

    test2( a2 = 123.12, a1 = 300)
    // 다른 프로그래밍 언어도 마찬가지이지만, 전달인수의 순서는 매개변수의 기수된 순서에 맞춰 넣어줍니다.
    // 다만 위와 같이 순서를 바꾸고자 한다면, '매개변수=' 을 써서, 전달인수와 매개변수의 짝을 맞춰줍니다.


    test3(100, 11.11)
    test3(200)
    // a2 에 전달할 값이 생략되어 기본값 0.0 이 a2 변수에 대입됩니다
    test3( a2=30.123 )
    // a1 에 전달할 값을 생략하려면 매개변수 이름을 써서 전달값만 전달합니다.
    test3()
    // 모두 생략할 수도 있습니다.

    val r1:Int = test4(100, 200.12)
    println("r1 : $r1")
    val r2:Int = test4(1000, 2000.123)
    println("r2 : $r2")
    println("---------------------------------------------")
    test5()
    test6()

    test7()
    test7(100)

    fun test10(){
        println("test10 호출")
    }
    test8()
    test10()
    // test9() //에러
}
// 함수안의 함수의 정의
fun test8(){
    println("test8 호출")

    fun test9(){
        println("test9 호출")
    }

    test9()
}

// 함수의 오버로딩 - 매개변수의 형태와 갯수를 달리한 같은 이름의 함수들을 정의하고 사용합니다
fun test7(){
    println("test7 호출 - 매개변수 없음")
    println("------------------------------")
}
fun test7(a1:Int=200){
    println("test7 호출 - 매개 변수 한 개(Int)")
    println("-----------------------------")
}


// Unit : void 의 의미로 사용되며, 대부분은 생략된채로 사용됩니다.
fun test5():Unit{
    println("test5 호출")
    println("----------------------------")
}
fun test6() {
    println("test6 호출")
    println("----------------------------")
}
// 리턴(반환)값이 있는 함수
// fun 함수이름(매개변수):리턴값의 자료형 {  }
fun test4( a1:Int, a2:Double ) : Int{
    println("test4 호출")
    val result:Int = a1 + a2.toInt()
    return result
}  // 변수 또는 리터럴 .toInt()  -> 변수 또는 자료의 형변환 (정수로 변화)




// 매개변수에 기본값(default값)이 지정된 함수 : 해당 매개변수에 전달되는 값이 없으면, 기본값이 변수에 대입 됩니다
fun test3(a1:Int = 0, a2:Double = 0.0){
    println("test3 호출")
    println("a1 : $a1")
    println("a2 : $a2")
    println("----------------------")
}






// 전달인수&매개변수가 있는 함수
// 매개변수는  var 없이 변수이름과 자료형만 기술합니다
fun test2( a1:Int  ,   a2:Double ){
    println("test2 호출")
    println("a1 : $a1")
    println("a2 : $a2")
    println("----------------------")
}



// 기본함수 ( 전달인수 없고 반환값 없는 함수
fun test1(){
    println("test1 함수 호출")
    println("----------------------")
}