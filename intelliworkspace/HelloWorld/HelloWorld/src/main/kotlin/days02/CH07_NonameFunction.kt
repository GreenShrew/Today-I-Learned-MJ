package days02

fun main(){
//    fun testFunction1(){
//        println("testFunction1 입니다.")
//    }
    // val testFunction2 = testFunction1
    // 자바스크립트에서 가능했던 함수의 직접 변수 저장은 불가능하다.

    // 아래와 같이 익명함수 저장은 가능하다
    // 익명함수 생성
    val t1 = fun(x1:Int, x2:Int) : Int{
        return x1 * x2
    }

    // 익명함수를 전달인수로 전달
    testFunc1(t1, 100, 200)
    // 전달인수로 직접 익명함수를 기술한다.
    testFunc1(fun(x1:Int, x2:Int):Int{return x1-x2} , 300, 400)
    // 전달인수로 람다함수를 보내는 경우 : 매개변수가 람다함수의 헤더이므로, 전달인수는 바디만 보내면 된다.
    testFunc1({x1:Int, x2:Int -> x1+x2}, 500, 600)
    // 전달인수와 매개변수의 조합은...  funcName:(Int, Int)->Int = {x1:Int, x2:Int -> x1+x2} 와 같다!
    println("-------------------------------------------")


    // 함수가 리턴값으로 리턴되어 변수에 저장된다.
    var t2 = testFunc2()
    var r2 = t2(600, 700)   // 정수형 매개변수 두개, 정수리턴으로 된 함수가 리턴되어 t2 에 저장되고 실행되는 형태이다.
    println("r2:$r2")
}


// 리턴값이 함수인 함수의 정의
// 함수의 리턴 자료형은 리턴되는 람다함수의 헤더((Int, Int)->Int)를 써준다.
// 실제 리턴되는 함수의 내용은 return 키워드와 함께 익명함수를 자유롭게 써준다.
fun testFunc2():(Int, Int)->Int{    // 람다함수의 헤더가 자료형으로 들어갔다.
    return fun(x1:Int, x2:Int):Int{ return x1*x2 }
}

// 람다함수가 리턴값이 되는 경우
fun testFunc3():(Int, Int)->Int{
    return { x1: Int, x2: Int -> x1-x2} // 람다함수가 리턴값으로 사용
}


// 매개변수중 하나는 함수를 저장할 수 있는 매개변수이다.
// 함수의 매개변수에 - 람다함수 헤더부분을 전달된 함수에 맞게 매개변수 이름과 함께 쓴다.
fun testFunc1( funcName:(Int, Int)->Int  , a1:Int, a2:Int) : Unit {  // 리턴값이 없으니 Unit
//    var a3 = funcName(100, 200)
    var a3 = funcName(a1, a2)
    println("a3 : $a3")
}