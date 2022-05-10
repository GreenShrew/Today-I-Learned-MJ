package days03

// CH18_Companion

// 자바에서  static  으로 사용되던 키워드가 companion 이라는 키워드로 바뀌어서 사용됩니다.
// 다만 static 은 각 변수나 메서드에 각각 붙여서 사용하지만,
//  companion 은 영역을 만들고 그안에 정적 멤버로 사용할 변수나 메서드를 다 넣습니다.

fun main(){
    // 인스턴스 멤버변수 또는 인스턴스 멤버 메서드의 가장 큰 특징 : 객체가 생성되지 않으면, 사용할수가 없습니다
    val obj1 = TestClass()
    println("obj1.a1 : ${obj1.a1}")
    obj1.testFun1()
    obj1.a1 = 200
    println("obj1.a1 : ${obj1.a1}")

    // companion 영역에 선언된 멤버들은 객체 생성없이, 클래스 이름과 함께 바로 사용이 가능합니다
    println("TestClass.a2 : ${TestClass.a2}")
    TestClass.testFun2()
}

class TestClass {
    var a1 = 100  // 인스턴스 멤버 변수
    companion object{
        var a2 = 1000
        fun testFun2(){
            println("testFun2")
            // println ("a1 : $a1")  // 에러    인스턴스 멤버는 companion(static) 메서드에서 접근할수 없습니다
            println("a2 : $a2")  // 정적 멤버 메서들에서는 정적 멤버 변수의 접근이 자유롭습니다
        }
    }
    fun testFun1(){  // 인스턴스 멤버 메서드
        println("testFun1")
        println("a1 : $a1")
        println("a2 : $a2")// 인스턴스 메서드는 객체유무와 상관없이 언제든 사용이 가능합니다
        testFun2()
    }
}