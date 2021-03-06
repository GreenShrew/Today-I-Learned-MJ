package days10;

public class Array14 {

	public static void main(String[] args) {
		// 1차원 배열의 복사
		int [] a = {1,2,3,4,5};
		int [] b;
		
		b=a;		// 이 코드는 b가 a의 주소를 복사한다.
		for(int k :a) {
			System.out.printf("%d ",k);
		}
		System.out.println();
		for(int k :b) {
			System.out.printf("%d ",k);
		}
		System.out.println();

		// 복사가 잘 된 것 같지만 문제가 있다.
		a[2] = 100;
		for(int k : a) {
			System.out.printf("%d ",k);
		}
		System.out.println();
		for(int k : b) {
			System.out.printf("%d ",k);
		}
		System.out.println();
		// 배열 a의 세번째 부분만 100으로 바꾸고 싶은데 b의 세번째 부분도 100이 되어버렸다.
		// 그 이유는 b = a; 코드는 배열을 복사하는게 아니라 '주소'를 복사하기 때문이다.
		
		// 레퍼런스 변수간의 값의 복사로는 배열의 복사까지 이루어지지 않는다.
		// 위의 동작 b=a;는 a가 갖고 있는 참고값(주소)를 b 변수에 복사한 것이므로
		// 배열 공간을 하나, 그 배열 주소를 저장한 변수는 두개로 설정한 것과 같다.
		// 따라서 a[2]값 변경은 b[2] 값 변경과 같은 결과가 나온 것이다.
		
		// 배열의 복사방법
		// 1. 새로운 공간을 new로 만들고 각 요소를 일일히 복사
		b = new int[5];	// 공간 5개를 만들고 b 초기화
		for(int i=0;i<a.length;i++) {
			b[i]=a[i];
		}
		a[4] = 300;
		for(int k:a) {
			System.out.printf("%d ",k);
		}
		System.out.println();
		for(int k:b) {
			System.out.printf("%d ",k);	// a 배열의 5번째 자리만 바뀐걸 볼 수 있다.
		}
		System.out.println();
		
		
		// 2. clone 메소드를 사용한 배열의 복사 : 배열명.clone()
		// 해당 배열변수가 레퍼런스(참조)하고 있는 장소의 배열을 새로운 공간에 복제한다.
		// c는 a 배열이 복제된 배열을 참조하는 변수
		int [] c = a.clone();	// 힙 영역에 배열의 복사본을 새로 만들고 그 주소를 전달
		a[1] = 200;
		for(int k : a) {
			System.out.printf("%d ",k);
		}
		System.out.println();
		for(int k : c) {
			System.out.printf("%d ",k);	// 2번 방법으로 a를 복제한 c 또한 두번째 자리가 바뀌지 않았다.
		}
		System.out.println();
		
		
		// 2차원 배열의 복사
		// 이차원배열(다차원배열)은 clone 메소드의 결과로 실제 일차원 배열을 관리하고 있는
		// 참조 변수들의 배열만 복사한다.
		int [][] d = {{1,2,3},{4,5,6}};
		int [][] e = d.clone();
		d[1][0] = 500;
		for(int i=0;i<e.length;i++) {
			for(int j=0;j<e[i].length;j++) {
				System.out.printf("%d  ",e[i][j]);	// d[1][0]만을 바꾸고자 했는데 e[1][0]도 500으로 바뀌어있다.
			}
			System.out.println();
		}
		// 2차원 배열은 새로 공간 생성후 각각의 값을 다시 복사해야 완벽한 복사가 된다.
		// 배열 f에 배열 d를 복사해보자.
		int [][] f = new int[d.length][d[0].length];
		for(int i=0;i<d.length;i++) {
			for(int j=0;j<d[i].length;j++) {
				f[i][j]=d[i][j];
			}
		}
		System.out.println();
		d[0][2] = 1000;
		for(int i=0;i<f.length;i++) {
			for(int j=0;j<f[i].length;j++) {
				System.out.printf("%d  ",f[i][j]);	// d[0][2]을 1000으로 바꾸었지만, f[0][2]는 3 그대로이다.
			}
			System.out.println();
		}
	}
}
