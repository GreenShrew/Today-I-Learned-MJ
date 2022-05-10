package days03

// CH17_Inteface

fun main(){

    val obj31 = TestClass31()  // Inter1 을 상속(구현)받은 자식클래스
    val obj32 = TestClass32()  // Inter2 를 상속(구현)받은 자식클래스
    val obj33 = TestClass33()  // Inter1, Inter2 을 상속(구현)받은 자식클래스
    obj31.inter1_Method1()
    obj31.inter1_Method2()
    obj32.inter2_Method1()
    obj32.inter2_Method2()
    obj33.inter1_Method1()
    obj33.inter2_Method1()
    obj33.inter1_Method2()
    obj33.inter2_Method2()
    // 부모중  해당 인터페이스가 구현되어있는 객체만 전달인수로 사용이 가능합니다.
    testFun1(obj31)   // obj32 는 전달할수 없습니다.
    testFun2(obj32)   // obj31 은 전달할수 없습니다.
    testFun1(obj33)   // Inter1 이 구현되었으므로 전달인수로 전달 가능
    testFun2(obj33)   // Inter2 이 구현되었으므로 전달인수로 전달 가능
}

fun testFun1( obj:Inter1 ){
    obj.inter1_Method1()
    obj.inter1_Method2()
}
fun testFun2( obj:Inter2 ){
    obj.inter2_Method1()
    obj.inter2_Method2()
}

// 인터페이스 : 추상클래스가 할 수 없었던 다중 상속이 가능합니다.
// 자바의 버젼이 업그레이드 되면서, 인터페이스에도 override 의 강제성이 부여되지 않은 일반 변수와 메서드 선언이 가능해졌습니다
interface  Inter1{
    fun inter1_Method1(){
        println("Inter1의 Method1입니다")
    } // override 의 강제성이 부여되지 않는 메서드
    fun inter1_Method2()  //override 강제성이 부여된 메서드
}
interface Inter2{
    fun inter2_Method1(){
        println("Inter2의 Method1입니다")
    }
    fun inter2_Method2()
}

// 인터페이스의 구현은 자식 클래스 이름 옆에 ":" 과 함께  () 괄호 없이 인터페이스의 이름만 기술합니다.
class TestClass31:Inter1{
    override fun inter1_Method2() {
        println("TestClass31의 오버라이딩 된 Method2 입니다")
    }
}
class TestClass32 : Inter2{
    override fun inter2_Method2() {
        println("TestClass32의 오버라이딩 된 Method2 입니다")
    }
}
// 두개이상의 인터페이스를 구현 하려면 인터페이스 이름들을 "," 로 구분하여 기술합니다
class TestClass33 : Inter1, Inter2{
    override fun inter1_Method2() {
        println("testClass33의 inter1에서 오버라이딩 된 Method2 입니다")
    }
    override fun inter2_Method2() {
        println("testClass33의 inter2에서 오버라이딩 된 Method2 입니다")
    }
}
