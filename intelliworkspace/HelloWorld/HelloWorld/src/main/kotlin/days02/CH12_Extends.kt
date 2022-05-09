package days02

fun main(){
    val s1 = SubClass1()    // 자식 클래스의 객체 생성
    println("s1.subMember1 : ${s1.subMember1}")
    s1.subMember1()
    println("s1.superMember1 : ${s1.superMember1}")
    s1.superMethod1()
}

// 상속이 될 클래스들이 final로 만들어진다. final 클래스는 상속이 불가능하므로, open 키워드를 앞에 붙인다.
open class SuperClass1{
    var superMember1 = 100
    fun superMethod1(){
        println("SuperClass1의 메서드 입니다.")
    }
}

// 상속은 extends 키워드 없이 부모클래스 이름을 ':', '()' 와 함께 클래스 옆에 써준다.
class SubClass1 : SuperClass1(){    // SuperClass1을 상속한다는 의미
    val subMember1 = 200
    fun subMember1(){
        println("SubClass1의 메서드 입니다.")
    }
}


// 부모클래스에 대표생성자가 있다면?
open class SuperClass2(val a1:Int){ }

// 상속을 위해 부모클래스의 이름을 쓰고, 괄호를 연결했다면, 괄호안에 부모클래스의 대표생성자 매개변수에 맞게 전달인수를 전달해준다.
// 그렇지 않으면 부모 클래스의 멤버변수가 생성되지 않고, 상속되 안 되는 에러가 발생된다.
class SubClass2 : SuperClass2(100){

}

// 자식클래스의 생성자가 따로 기술되어야 한다면 아래와 같이 표현할 수 있다.
class SubClass3 : SuperClass2{
    constructor() : super(100){

    }
}

// 자식클래스에도 대표 생성자가 있다면
class SubClass4(var a4:Int) : Superclass2(100){

}