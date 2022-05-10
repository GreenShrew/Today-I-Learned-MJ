package days03
// kind  와 number 를 멤버변수로 만들고 생성자에 전달된 값으로 멤버변수의 값을 대입하는 대표생성자를 이용하여 완성해주세요
// 전달인수가 없는 보조 생성자도 생성해 주세요(대표생성자에 4와 1을 전달하는 대표생성자 호출 포함)
// 그 외 사항은 코틀린 코드를 이용하여 이전클래스와 같은 동작을 할수 있게 적절히 처리합니다.
// spade, diamond, heart, clover  변수는 자바의  static 처럼 생성해주세요
class Card ( var kind:Int, var number:Int ){
    companion object{
        val spade = 4
        val diamond = 3
        val heart = 2
        var clover = 1
    }

    constructor() : this(4, 1){}

    override fun toString() : String{
        val kinds = arrayOf<String>("", "♣", "♥", "◆", "♠")
        val numbers = arrayOf<String>("","A","2","3","4","5","6","7","8","9","10","J","Q","K")
        val str:String  = "[" + kinds[this.kind] + ":" + numbers[this.number] + "]"
        return str
    }
}