package days10;

public class Method04 {
	// Call by Reference 방식의 메서드 호출
	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		int [] a = {111,222,333,444};
		System.out.println("\nmain에서 출력 : ");
		for(int i=0;i<a.length;i++) {
			System.out.printf("a[%d] = %d\t",i,a[i]);
		}
		
		updateValue(a);		// 전달인수로 참조값을 전달한다.
		// 메서드의 매개변수로 참조변수의 값을 넘겨주는 방식(배열 이름 변수, String 참조 변수, Class 참조변수 등)
		// 호출된 메서드에서 참조값을 사용해 값을 변경하게 되면 호출한 곳이 가리키는 곳의 메모리에 직접 반영된다.
		System.out.println("\nmain 에서 출력 : ");
		for(int i=0;i<a.length;i++) {
			System.out.printf("a[%d] = %d\t",i,a[i]);	// Call by Value와는 달리 배열 a의 값이 바뀌어있다.
		}
	}
	// int [] b -> 전달인수로 주소(참조값)가 전달되므로 매개변수도 주소를 저장할 참조변수가 있어야 정상실행된다.
	public static void updateValue(int[]b) {	// main과 updateValue가 {111,222,333}을 가지고있는 주소를 공유한다!
		b[0]=100; b[1]=200; b[2]=300;
		System.out.println("\nupdateValue 에서 출력 : ");
		for(int i=0;i<b.length;i++) {
			System.out.printf("b[%d] = %d\t",i,b[i]);
		}
	}
}
// Call by Value, Call by Reference의 차이를 이렇게 이해해보자.
// Call by Value는 사진의 복사본을 다른이에게 보여준다. 수정 불가능.
// Call by Reference는 사진이 있는 집의 주소를 알려준다. 수정 가능.