package days03

// CH16_Abstract

fun main(){
    val obj1 = Sub1()
    obj1.method1()
    obj1.method2()

    println("----------------------------------------------")
    val obj2 = Sub2()
    testFun1(obj2)
    testFun1(obj1)
}

// 부모클래스의 참조변수가 멤버변수로 있기때문에, 그 자식 클래스의 객체를 전달인수로 전달할수 있습니다.
fun testFun1(obj1:Super1){
    obj1.method1()
    obj1.method2()
}

// 추상클래스 : 상속을 위한 클래스. 멤버메서드의  override에 강제성을 부여하기위해 사용
open abstract class Super1{
    // 재정의(override) 의 강제성이 있는 메서드와 없는 메서드를 동시 사용이 가능합니다.
    fun method1(){
        println("Super1의 method1 입니다")
    }
    open abstract fun method2()  // 재정의(override) 강제성이 부여된  추상메서드
}

class Sub1:Super1(){
    override fun method2() {
        println("Sub1의 method2 입니다")
    }
}

class Sub2:Super1(){
    override fun method2() {
        println("Sub2의 method2 입니다")
    }
}