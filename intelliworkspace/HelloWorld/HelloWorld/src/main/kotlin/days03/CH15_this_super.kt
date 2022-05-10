package days03

//  CH15_this_super

fun main(){
    var obj1  =TestClass21()
    obj1.testMethod1()
}

// this 의 용도
// 1. 멤버변수와 매개변수(또는 지역변수)의 이름이 같을때 그들을 구분하기 위해 사용합니다.
// 2. 대표생성자가 있는경우 보조 생성자에서 기본생성자의 매개변수 갯수와 자료형에  맞춰서 반드시 호출해야 하는데,  이때  this 카워드를 사용합니다.
// 3. 매서드 내부에 다른 매서드(이름하여 지역 매서드:지역변수와 같은 의미)를 만들어 쓸수 있는데 맴버메서드와 구분하기 위해 사용합니다.
class TestClass21 (var a2:Int) {
    var a1:Int = 200
    constructor():this(300){
        // 보조생성자는 반드시 대표생성자를 this 키워드를 이용해서 호출해야합니다. 대표생성자의 메개변수가 멤버변수로 생성이 되어 야하는데
        // 호출되지 않으면 생성되지 않기때문에....
    }
    fun testMethod1(){
        var a1 = 100
        println("메서드의 지역변수 a1 : $a1")
        println("a1 : ${this.a1}")
        // $this.a1 이라고 쓰고 출력하면, 클래스이름@해시코드.a1 으로 출력될수 있습니다.  멤버변수의 값을 출력하고자 한다면 위와 같이
        // ${this.a1} 라고 씁니다
        fun testMethod2(){
            println("testMethod1 메서드 내부의 testMethod2 메서드")
        }
        testMethod2()  // 지역 메서드 우선 실행
        this.testMethod2()  // 멤버메서드를 실행하려면  this 키워드를 사용합니다
    }
    fun testMethod2(){
        println("멤버메서드 testMethod2")
    }


}

// super 의 용도
// 1. 상속관계의 자식 생성자에서, 부모클래스의 생성자를 호출할때, 자식클래스의 이름옆에 부모 클래스의 이름을 사용하지만,
// 보조 생성자에서는 super 라는  키워드를 사용합니다
// 2.  자식클래스에서 오버라이드된 메서드 그리고 변수 를 사용할때, 인위적으로 부모의  메서드를 호출하거나 변수값을 취할때 사용합니다.

open class SuperClass(var a2:Int){  // 대표 생성자
    open var a1 = 100
    constructor() : this(200){   }  // 보조 생성자
    open fun superMethod1(){
        println("SuperClass의 superMethod1")
    }
}
// 대표생성자와 보조생성자가 모두 있는 부모 클래스는 둘 중 어떤 형태로도 상속(부모클래스 생성자호출)이 가능합니다
class SubClass11 : SuperClass() {
    override fun superMethod1() {
        super.superMethod1() // 부모클래스의 메서드
        println("super.a1 : ${super.a1}") // 부모클래스의 멤버변수
        println("SubClass의 superMethod1")
    }
}
class SubClass12 : SuperClass {
    // constructor 키워드로 생성된 생성자 이름 옆에 super 키워드를 이용하여 부모 클래스의 대표 생성자 직접 호출할 수 있습니다
    // 그 경우 Extends 로 연결되는 부로클래스 이름 옆의 괄호는 지워줍니다
    //  class SubClass12 : SuperClass()  -> class SubClass12 : SuperClass
    constructor(a1:Int) : super(a1){ }
}