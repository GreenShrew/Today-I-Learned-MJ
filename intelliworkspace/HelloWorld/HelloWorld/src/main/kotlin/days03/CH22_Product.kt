package days03

//  CH22_Product

fun main(){

}
open class Product( val price:Int, val bonusPoint:Int ) {
    constructor( price:Int ) : this( price,  (price/10).toInt() )
}
class Computer : Product( 150 ){
    override fun toString(): String {
        return "Computer"
    }
}
class Tv : Product( 100 ){
    override fun toString(): String {
        return "Tv"
    }
}
class Audio : Product( 60 ){
    override fun toString(): String {
        return "Audio"
    }
}

class Buyer{
    var money:Int = 1000;      var bonusPoint = 0;      var item = mutableListOf<Product>()
    fun buy( p:Product ){
        if( this.money < p.price ){
            println("잔액이 부족합니다");
            return;
        }
        this.money -= p.price;          this.bonusPoint += p.bonusPoint;           println("$p 을/를 구입하셨습니다");        item.add(p);
    }
    fun summary(){
        if( item.isEmpty() ){
            println("구입하신 제품이 없습니다")
            return
        }
        var sum:Int = 0
        var itemList:String = ""
        for( k in item ){
            if( k is Product ) {     // if 문 안에서는 Product형으로 사용하도록 스마트 캐스팅이 일어납니다다
               sum += k.price;                    itemList = itemList + "  " + k
            }
        }
        println("지출총액 : " + sum + ",    구매목록 : " + itemList)
    }

    fun refund( p:Product ){
        if( item.remove(p) ){
            this.money += p.price
            this.bonusPoint -= p.bonusPoint
            println("$p 을/를 반품하셨습니다")
        } else {
            println("구입하신 물품중에 해당 제품이 없습니다")
        }
    }
}