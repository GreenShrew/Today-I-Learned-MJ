package days03
// CH20_List

// 코틀린의 컬렉션
// List : 순서를 통해 관리한다.
// Map : 이름을 통해 관리한다.
// Set : 집합 관리
fun main(){
    // List
    // 배열과 동일하게 인덱스 번호를 통해 객체를 관리한다.
    // 배열을 크기가 정해지면 변경할 수 없지만 List는 추가, 삭제 등이 가능하다.
    // List 의 생성
    // listOf : 불변형 리스트 생성
    // mutableListOf : 가변형 리스트 생성
    // emptyList : 비어있는 불변형 리스트를 생성한다.
    // listOfNotNull : null을 제외한 나머지만으로 리스트를 생성한다.
    val list1 = listOf(10,20,30,40,50)
    val list2 = listOf( "문자열1", "문자열2", "문자열3")
    println("list1 : $list1")
    println("list2 : $list2")
    var list3 = mutableListOf<Int>()  // 가변형이기 때문에 더러는 비어있는 상태로 시작되고 요소들을 추가하여 변경합니다
    var list4 = mutableListOf("문자열1", "문자열2", "문자열3")
    println("list3 : $list3")
    println("list4 : $list4")
    val list5 = emptyList<Int>()
    println("list5 : $list5")
    // null 을 제외한 나머지 들로 리스트를 구성
    val list6 = listOfNotNull(10, 20, null, 30, null, 40, 50)
    println("list6 : $list6")

    for(item in list1){
        print("$item ")
    }
    println("\nlist1 size : ${list1.size}")

    println("-------------------------------------------")

    // 리스트의 값에 접근
    // get : 0부터 시작하는 인덱스 번호를 통해 객체를 추출할 수 있습니다.
    // Kotlin의 리스트는 배열과 동일하게 [ ]를 사용할 수 있습니다
    println("list1 0 : ${list1.get(0)}")
    println("list1 1 : ${list1.get(1)}")
    println("list1 2 : ${list1[2]}")
    println("list1 3 : ${list1[3]}")



    println("-------------------------------------------")
    // 기타메서드
    // indexOf : 지정된 값의 인덱스 번호를 반환한다. 값이 없을 경우 -1을 반환합니다.
    // lastIndexOf : 지정된 값이 마지막에 해당하는 값의 인덱스 번호를 반환합니다.  값이 없을 경우 -1을 반환합니다.
    // subList : 지정된 범위의 값을 추출하여 새로운 리스트를 생성해 반환합니다.
    val list7 = listOf(10, 20, 30, 10, 20, 30)
    val index1 = list7.indexOf(20)
    println("index1 : $index1")
    val index2 = list7.lastIndexOf(20)
    println("index2 : $index2")
    val list8 = list1.subList(1, 3)
    println("list8 : $list8")


    println("-------------------------------------------")
    // 가변형 리스트의 메서드
    // add(객체) : 객체를 추가합니다.
    // add(인덱스, 객체) : 주어진 인덱스 위치에 객체를 삽입합니다.
    // remove(객체) : 주어진 객체를 제거합니다
    // removeAt(인덱스) : 주어진 인덱스의 객체를 제거합니다.
    // set(인덱스, 객체) : 주어진 인덱스에 객체를 덮어씌웁니다.
    list3.add(10)
    list3.add(20)
    list3.add(30)  // 가변 리스트에 요소를 하나씩 추가합니다
    list3.addAll(listOf(40, 50, 60))  // 가변 리스트에 요소를 한번에 여러개 추가합니다
    println("list3 : $list3")
    list3.add(1, 100)  // 특정인덱스에 데이터 추가합니다. 뒤에 요소를 한칸씩 밀립니다
    println("list3 : $list3")     // 특정인덱스에 데이터를 여러개 한번에 추가합니다. 뒤에 요소를 한칸씩 밀립니다
    list3.addAll(2, listOf(200, 300, 400))
    println("list3 : $list3")    // 리스트 요소중 해당 값을 한개 또는 여러개 제거합니다
    list3.remove(100)
    println("list3 : $list3")
    list3.removeAll(listOf(200, 300))
    println("list3 : $list3")
    list3.removeAt(1)  // 지정한 인데스의 요소를 삭제합니다
    println("list3 : $list3")
    list3.set(1, 200)  // 지정한 인덱스에  지정한 값으로 수정합니다
    println("list3 : $list3")
    list3[2] = 300  // 배열처럼 지정한 인덱스에  지정한 값으로 수정합니다
    println("list3 : $list3")

    println("-----------------------------------------------")
    // 불변형 리스트(list1)를 가변형으로 변환
    // list1.add(1000)  // 불변형이기때문에 요소 추가는 에러
    val list100 = list1.toMutableList() // 불변형 -> 가변형 : 불변형의 변환결과를 다른 참조변수에 전달
    list100.add(1000)
    println("list100 : $list100")

    val list200 = list100.toList()  // 가변형 -> 불변형
    // list200.add(300)  //에러
}