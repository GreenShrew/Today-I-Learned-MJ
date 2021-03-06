package days04;

public class Operator04 {

	public static void main(String[] args) {
		// 논리연산자 &&(AND), ||(OR), !(NOT)
		// 다수개의 관계(비교)연산식 결과를 조합하여 하나의 boolean 값을 결과로 얻는 연산
		
		// 피연산자 : boolean, 연산의 결과 : boolean
		int a = 80;
		boolean b = true && false;	// 기본 구조. 우항에서 연산을 통해 true false를 가려내고 좌항의 변수에 넣는다.
		boolean b1 = a>70;		// true
		boolean b2 = a<100;		// true
		b = b1 && b2;				// true
		// 이런 구조로 만들어진다.
		// 위 구조를 19번 코드와 같이 한줄로 만들 수 있다.
		
		// a 변수의 값이 70보다 크고 100보다 작으면 true, 아니면 false를 출력
		b = (70<a) && (a<100);
		// 참고로 연산의 우선순위는 &&, || 과 같은 연산자보다 부등호 연산자가 우선순위를 가진다. 따라서 괄호는 없어도 됨.
		System.out.println("70 < a < 100 : " + b);
		// 주의! 70 < a < 100 이러한 연산은 불가능하다. 
		
		a = 30;
		// a 변수의 값이 70보다 크거나 40보다 작으면 true, 아니면 false 출력
		b = (70<a) || (a<40);
		System.out.println("70 < a 이거나 a < 40 : " + b);

		
		// AND 연산자 (&&)
		// 좌항과 우항의 관계(비교)식 결과 또는 boolean 값이 모두 true인 경우 true가 결과값으로 출력.
		// 좌항과 우항 중 하나라도 false인 경우 false가 결과값으로 출력.
		// 좌항의 비교연산 결과가 false인 경우 우항의 식을 비교하지 않는다. (이미 false이기 때문)
		System.out.printf("F && F = %b\n", false&&false);
		System.out.printf("T && F = %b\n", true&&false);
		System.out.printf("F && T = %b\n", false&&true);
		System.out.printf("T && T = %b\n", true&&true);
		
		System.out.println("-----------------------------");
		
		// OR 연산자 (||)
		// 좌항과 관계(비교)식 결과 또는 boolean 값이 하나라도 true인 경우 true가 결과값으로 출력.
		// 좌항과 우항 모두 false인 경우 false가 결과값으로 출력.
		// 좌항의 결과가 true인 경우 우항의 식을 비교하지 않는다. (이미 true이기 때문)
		System.out.printf("F || F = %b\n", false||false);
		System.out.printf("T || F = %b\n", true||false);
		System.out.printf("F || T = %b\n", false||true);
		System.out.printf("T ||T = %b\n", true||true);		
		
		System.out.println("-----------------------------");
		
		// NOT 연산자(!)
		// 단항연산자(피연산자가 1개임)
		// 관계식의 결과를 반대값으로 바꾸어 나타냄. true -> false, false -> true
		System.out.printf("Not %b = %b\n", false, !false);
		System.out.printf("Not %b = %b\n", true, !true);
		
		// 어떤 상황에서 이런게 쓰일까?
		// 점수가 80점 이상이면서 90점 이하면 true, 아니면 false 출력
		int number = 80;	//(이면서, 그리고, ~이고)
		boolean result = (number>=80) && (number<=90);
//		result =  80 <= number <= 90		이렇게 쓰면 오류.
		System.out.printf("result = %b\n", result);
		
		// 점수가 100 이상이거나 50 미만이면 true, 아니면 false	(이거나, 또는)
		number = 150;
		result = (number>=100) || (number<50);
//		result = 100 >= number < 50			이렇게 쓰면 오류.
		System.out.printf("result = %b\n", result);
	}

}
