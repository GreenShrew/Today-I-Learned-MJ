package days03

// CH19_TypeCasting

fun main(){
    var a1:Int = 100
    //var a2:Double = a1
    var a2:Double = a1.toDouble()

    var b1:Double = 123.12
    // var b2:Int = b1
    var b2:Int = b1.toInt()

    var c1:String = "12234"
    var c2:Int = c1.toInt()

    var d1:String = "122.34"
    var d2:Double = d1.toDouble()

    // val d3:String = "안녕하세요"
    // val number4:Int = d3.toInt()

    // 부모 클래스 타입 참조변수에 자식 인스턴스를 담을 수 있습니다
    // 스마트 캐스팅 발생
    val super1:SuperClass4 = SubClass41()
    // 스마트 캐스팅 발생
    val inter1:Inter4 = SubClass42()

    // val sub1:SubClass41 = (SubClass41)super1     // 자바 문법
    // val sub2:SubClass42 = (SubClass42)inter1       // 자바 문법
    // 자식인터페이스가 부모레퍼런스에 저장되었다가,  다시 자식 레퍼런스에 옮겨질때 강제캐스팅이 필요하다는건
    // 자바와 코틀린 똑같습니다. 부모레퍼런스에 저장되었다가 옮겨지는 인스턴스도 반드시 자식 인스턴스여야 한다는 제약도 똑같습니다
    // 다만 문법상 표현방법이 다릅니다

    // 자식 인스턴스를 담고 있는 부모 레퍼런스 변수가 자식 레퍼런스에 값을 전달하려면,
    // 자바에서처럼 강제캐스팅 하지 아래와 같이 명령합니다
    super1 as SubClass41    // super1 = (SubClass41)super1
    inter1 as SubClass42    // inter1 = (SubClass42)inter1
    // 위 명령은 super1과 inter1 에 있는 레퍼런스 값을
    // 옮기려는 자식 클래스 자료형의 "다른 변수에 형변환 과 함께 옮기는 것이 아니라"

    // super1  변수와 inter1 변수를 "자식 클래스의 레퍼런스 변수로 변경시켜버립니다."
    // 자식 클래스 레퍼런스 변수로 값을 옮겨 담는 것이 아니라, 저장된 참조값을 놔두고 변수자료형을 변경해 버린다는 뜻입니다.
    println("변경 후 super1 : $super1")
    println("변경 후 inter1 : $inter1")

    // 위 두개의 경우는 형변환전에 안전한 실행을 위해  형변환이 가능한지에 대한 점검이 필요합니다
    // 자바에서는
    // if( super1 instanceof SubClass41 ) {
    //      val sub1:SubClass41 = (SubClass41)super1  //형변환 명령
    //  }
    // 코틀린에서는
    // if( super1 is SubClass41 ){
    //    super1 as SubClass41 // 코틀린 강제 형변환 명령
    // }



    val super2:SuperClass4 = SubClass41()
    val inter2:Inter4 = SubClass42()
    // 부모레퍼런스가 저장하고 있는 자식인스턴스를 자식 레퍼런스에 옮길텐데,
    // 위에서 언급한거 처럼 코틀린은 옮기지않고, 레퍼런스 변수 자체를 변경해버립니다
    // 그전에 변경이 가능한지 검사
    if( super2 is SubClass41 ){
        super2 as SubClass41  // if문의 중괄호 밖에서도 형변환 결과를 활용할수 있습니다.
    } else {
        println("형변환이 불가능합니다.")
    } // 검사결과가 참이면 변환, 거짓이면 변환하지 않음

    if( inter2 is SubClass42 ) {
        // is 에 의해 열린 if 문 안에서는  as 를 쓰지 않아도
        // is 연산자 값이 true라면 형변환이 가능한 상황이므로 스마트 캐스팅 실행
        // 현재위치 중괄호 { } 안에서는 이미  inter2 는 SubClass42의 레퍼런스로 변경된 상태이며, 그상태로 사용이 가능합니다
        // 다만  중괄호를 벗어나면  다시  Inter2(부모인터페이스)의 레퍼런스로 되돌아갑니다
        // 중괄로가 끝나도 계속 변경상태를 유지하려면   inter4 as SubClass42  를 사용합니다다
    }

}

open class SuperClass4
interface Inter4
class SubClass41 : SuperClass4(){
    fun subMethod1(){
        println("SubClass21의 subMethod1입니다")
    }
}
class SubClass42 : Inter4{
    fun subMethod2(){
        println("SubClass21의 subMethod2입니다")
    }
}