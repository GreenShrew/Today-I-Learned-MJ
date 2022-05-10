package days03

// CH14_Any

// Any 클래스는 자바에서의  Object  클래스와 같은 모든 클래스의 부모클래스가 되는 클래스입니다.
// 이미 만들어져있거나, 앞으로 생성될 클래스에 따로 명시하지 않아도,  다른 클래스를 상속받지 않고 있다면 그 클래스는
// Any  클래스를 상속받고 있다고 보아야 합니다.
// 다만 다른 클래스를 상속 받고 있는 클래스는 그 부모 클래스가 Any 클래스를 상속 받고 있기때문에 결과적으로  자기 자신도
// Any 클래스의 자식(손자) 클래스가 된다고 보아야 합니다.

fun main(){
    val obj1 = TestClass11()
    println("obj1 : $obj1")
    // 참조변수를 println 에 넣으면 Any  클래스에서 상속 받은 toString() 메서드가 실행되어
    // 클래스 이름과 해쉬 코드가 출력됩니다. obj1 : days03.TestClass11@29453f44

    // Any 클래스에서 상속 받은 toString 매서드를 오버라이드 클래스는 재정의 된 메서드가 실행됩니다.
    val obj2 = TestClass12()
    println("obj2 : $obj2")

    testFun(obj1)
    testFun(obj2)
}

// 매개변수의 자료형이 Any  라는 것은 모든 클래스의 객체가 전달인수로 전달될 수 있다는 뜻입니다.
fun testFun( a:Any ){
    println("a : $a")
}

class TestClass11{}

class TestClass12{
    // Any 클래스에서 상속받은 toString 을 오버라이딩해서 사용할 수 있습니다
    override fun toString(): String {
        return "TestClass12 객체입니다"
    }
}
