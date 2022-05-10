package days03

// CH13_Override

fun main(){
    // 상속이 구현된 자식 클래스를 이용하여 객체를 만들고 자식클래스가 새로 만든 변수를 출력하고 메서드를 실행해봅니다
    val obj1:SubClass1 = SubClass1()
    println("obj1.subA1 : ${obj1.subA1}")
    obj1.subMethod1()
    // 상속받은 부모 클래스의 변수를 출력하고, 부모클래스에 있는 메서드를 실행합니다/
    println("obj1.superA1 : ${obj1.superA1}")
    obj1.superMethod1()

    println("-------------------------------------------------")
    val obj2:SubClass2 = SubClass2()
    // 오버라이딩 된 매서드를 실행합니다
    obj2.superMethod2()
    // 부모클래스의 레퍼런스변수에 작식클래스의 인스턴스를 저장합니다.
    val obj3:SuperClass2 = SubClass2()
    // 부모클래스의 레퍼런스 변수로 호출한 메서드는.... 자식 클래스에서 재정의된 매서드가 우선 실행됩니다
    obj3.superMethod2()
    println("--------------------------------------------------")

    Test1(obj2);  // 전달인수로 자식 인스턴스주소 전달
    val obj4:SuperClass2 = SuperClass2()
    Test1(obj3)  // 전달인수로 부모 인스턴주소 전달
}

fun Test1( obj:SuperClass2 ){
    obj.superMethod2();
}


// 메서드 오버라이딩을 위한 상속
open class SuperClass2 {
    // 오버라이드될 부모클래스의 메서드는 반드시 앞에 open 을 붙여서 씁니다
    open fun superMethod2(){
        println("SuperClass2의 superMethod2")
    }
}
class SubClass2 : SuperClass2() {
    override fun superMethod2() {
        // super.superMethod2()   // 부모클래스의 오버라이딩 되기전 메서드 호출 : super 키워드 이용
        println("SubClass2의 오버라이딩 된 superMethod2")
    }
}



// 일반적인 상속
open class SuperClass1{  // 상속을 하기위해 클래스를  open 을 사용하여 생성합니다
    var superA1 = 100
    fun superMethod1(){
        println("SuperClass1의 superMethod1 입니다")
    }
}
// SuperClass1 클래슬를 상속 받는 SubClass1 을 생성합니다
class SubClass1 : SuperClass1(){
    var subA1 = 200
    fun subMethod1(){
        println("SubClass1의 subMethod1 입니다")
    }
}