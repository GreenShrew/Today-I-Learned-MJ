package days06;

public class ControlOpFor01 {

	public static void main(String[] args) {
		// '겁나 쉬운 자바 프로그래밍'을 세번 실행시키는 방법.
		System.out.println("겁나 쉬운 자바 프로그래밍!");
		System.out.println("겁나 쉬운 자바 프로그래밍!");
		System.out.println("겁나 쉬운 자바 프로그래밍!");
		// 이걸 100번 실행한다고 하면 100줄의 코드를 짜야하는데 이건 매우 비효율적이다!
		
		// for 명령 : 반복 실행 명령
		// 괄호 안에 ; 으로 구분해서 세가지 내용을 기술해준다.
		// for(  ;  ;  ) {  }
		// 작성되는 세가지 내용은 반복횟수를 제어할 구성요소들로 채워진다.
		// 또한, 반복되는 횟수는 특정 변수값을 통해서 제어된다.
		
		// 첫번째 요소 : 반복을 제어하는 변수의 최초값 대입 또는 변수의 생성 영역이다.
		// 두번째 요소 : 다음 반복을 계속할지 안할지에 대한 관계(비교)연산식.
		//		(결과 true/fales) - 비교연산식의 결과가 true이면 반복을 계속하고, false이면 반복을 멈추고 for 영역을 빠져나온다.
		// 세번째 요소 : 반복 제어 변수의 증감 연산
		
		System.out.println();
		
		// 반복 실행을 제어할 변수를 하나 생성한다.
		int i;
		for( i=1 ; i<=10 ; i++ ) {	// 혹은 for( i=1 ; i<=10 ; i++ )	i의 변수 지정 위치에 대한 내용은 지역변수 공부! + 아래에 '변수의 수명' 참고
			System.out.println("겁나 쉬운 자바 프로그래밍!");
		}
		// 첫번째 요소 : i 변수가 1을 최초로 갖고 반복이 실행된다.
		// 두번째 요소 : i 값이 10 보다 작거나 같은 경우 현재의 반복실행을 진행한다.
		// 세번쨰 요소 : 계산할 i 변수의 증감연산을 실행한다.
		// 1 증가 i++	1감소 i--		2증가 i=i+2(i+=2)	2감소 i=i-2(i-=2)
		//매 반복마다 i++이 실행되서 i<=10이 false가 되는 순간 반복이 멈춘다.
		
		// ------------------------------------------------------------
		// 열번의 반복실행을 위해서 i 변수값을 반드시 1부터 10으로 설정할 필요는 없다.
		for(i=11;i<=20;i++) {
			System.out.println("1겁나 쉬운 자바 프로그래밍!");
		}
		for(i=101;i<=110;i++) {
			System.out.println("2겁나 쉬운 자바 프로그래밍!");
		}
		for(i=29;i>=20;i--) {
			System.out.println("3겁나 쉬운 자바 프로그래밍!");
		}
		// ------------------------------------------------------------
		// for문에 속한 반복대상 명령이 하나라면 중괄호를 생략할 수 있다.
		for(i=0;i<=9;i++) System.out.println("4겁나 쉬운 자바 프로그래밍!");
		for(i=0;i<10;i++) System.out.println("5겁나 쉬운 자바 프로그래밍!");
		// ------------------------------------------------------------
		// 변수 이름이 반드시 i일 필요는 없다.
		int j;
		for(j=0;j<10;j++) System.out.println("6겁나 쉬운 자바 프로그래밍!");
		// ------------------------------------------------------------
		// 반복을 제어하는 변수의 반복실행문 안쪽 선언
		for( int k=101 ; k<=110; k++) {
			System.out.println("7겁나 쉬운 자바 프로그래밍!");
		}	// 변수 k는 이 후로 쓸 수 없다. 다시 쓰고싶다면 int k;와 같이 다시 선언해야한다.
		// 변수의 수명 : 자신을 생성한 영역 { } 이 끝나면 변수도 소멸된다.
//		 System.out.println("반복실행변수의 최종값: " +k);		에러
		// 안쪽 변수는 반복실행후 제어변수를 더이상 사용치 않을 때 사용한다.
		// 반복 실행 후 반복제어 변수의 값이 필요하다면 for문 안쪽에 변수를 선언하면 안된다.
		// 해당 변수를 더 쓰고싶다면 반드시 반복 실행문 위에 별도로 선언 후 사용해야한다.
	}

}
