package days02

fun main(){
    // 단항 연산자 : 항이 하나인 연산자
    // + : 양수 -> 양수, 음수 -> 음수
    val a1:Int = 10;    val a2:Int = -10;
    val r1:Int = +a1;    val r2:Int = +a2;
    println("a1 : $a1, r1 : $r1")
    println("a2 : $a2, r2 : $r2")
    // - : 양수 -> 음수, 음수 -> 양수
    val r3:Int = -a1;    val r4:Int = -a2;
    println("a1 : $a1, r3 : $r3")
    println("a2 : $a2, r4 : $r4")
    // ! : true -> false, false -> true
    val a3:Boolean = true;  val a4:Boolean = false;
    val r5:Boolean = !a3;  val r6:Boolean = !a4;
    println("a3 : $a3, r3 : $r5")
    println("a4 : $a4, r4 : $r6")
    println("----------------------------------")



    var a5:Int = 10;    var a6:Int = -10;
    val r7:Int = a5++;    val r8:Int = a6--;
    println("a5 : $a5, r7 : $r7")
    println("a6 : $a6, r8 : $r8")
    var a7:Int = 10;    var a8:Int = -10;
    val r9:Int = ++a7;    val r10:Int = --a8;
    println("a7 : $a7, r9 : $r9")
    println("a8 : $a8, r10 : $r10")
    println("----------------------------------")

    val r11:Int = 10 + 3
    val r12:Int = 10 - 3
    val r13:Int = 10 * 3
    val r14:Int = 10 / 3
    val r15:Int = 10 % 3
    println("$r11, $r12, $r13, $r14, $r15")


    val a14:Int = 10
    val r17:Boolean = a14 == 10;
    val r18:Boolean = a14 != 10;
    println("$r17, $r18")
    val r19:Boolean = a14 == 20;
    val r20:Boolean = a14 != 20;
    println("$r19, $r20")
    println("----------------------------------")

    val a15:Int = 10
    val r21:Boolean = a15 < 20
    val r22:Boolean = a15 > 20
    val r23:Boolean = a15 <= 20
    val r24:Boolean = a15 >= 20
    println("$r21, $r22, $r23, $r24")


    val r16:IntRange = 10..20   // 10 부터 20 까지의 영역테이터(관리데이터)
    println("r16 : $r16")   // 출력 : 10..20 내부 숫자 11개를 모두 출력하려면 반복실행이 필요하다!
    println("----------------------------------")

    val r25:IntRange = 20..50
    val r26:IntRange = 10..30

}