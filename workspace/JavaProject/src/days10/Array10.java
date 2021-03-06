package days10;

public class Array10 {

	public static void main(String[] args) {
		// 배열 a, b, c 생성 (각 갯수 10개)
		// a 배열에는 3의 배수들 10개 저장 - 반복실행문 이용
		// b 배열에는 5의 배수들 10개 저장 - 반복실행문 이용
		// c 배열에는 a배열과 b배열의 각 같은 인덱스값들의 합을 저장 - 반복실행문 이용
		// ex) c[3] = a[3]+b[3];
		// 출력
		// a배열 -> 3, 6, 9, 12...
		// b배열 -> 5, 10, 15, 20...
		// c배열 -> 8, 16, 24, 32...
		
		int a[],b[],c[];
		a=new int[10];
		b=new int [10];
		c=new int [10];
		
		for(int i=0;i<10;i++) {
			a[i]=(i+1)*3;
			b[i]=(i+1)*5;
			c[i]=a[i]+b[i];
		}
		System.out.printf("\na배열 -> ");
		for(int i=0;i<a.length;i++) {
			System.out.printf("%d ", a[i]);
		}
		System.out.printf("\nb배열 -> ");
		for(int i=0;i<b.length;i++) {
			System.out.printf("%d ", b[i]);
		}
		System.out.printf("\nc배열 -> ");
		for(int i=0;i<c.length;i++) {
			System.out.printf("%d ", c[i]);
		}
	}

}
