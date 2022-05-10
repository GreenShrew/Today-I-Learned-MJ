package days03
class CardDeck {
    // 멤버변수 cards  :  Card 객체 52개의 요소를 갖는 배열 -  배열의 52칸을 카드객체로 채워서 생성
    var cards = Array<Card>(52, { Card() } )
    // 생성자 : 배열에 있는 Card 52장을 스페이드1(A) ~ 클로버 13(K)까지 채우는 동작
    constructor(){
        var k=1   // kind 값을 넣기위한 변수
        var n=1   // number 값을 넣기 위한 변수
        var p=0   // 배열의 인덱스(0~51)를 위한 변수
        while( k<=4){
            n=1
            while(n<=13){
                cards[p].kind = k
                cards[p].number = n
                n++
                p++
            }
            k++
        }  // 카드덱에 있는 52장의 spade:A 카드들을 무늬와 숫자를 다시 새겨넣습니다.
    }
    // shuffle메서드 : 52장을 골고루 섞는 메서드    ( Math.random() *52 ).toInt()
    fun shuffle(){
        var temp:Card = Card()
        var i:Int = 0
        while( i<52 ){
            var r:Int = ( Math.random() * 52 ).toInt()
            temp = cards[i]
            cards[i] = cards[r]
            cards[r] = temp
            i++
        }
    }
    // pick 메서드 : 전달인수로 온 정수 번째의 카드를 리턴해주는 메서드드
    fun pick(i:Int) : Card{
        return cards[i]
    }
}