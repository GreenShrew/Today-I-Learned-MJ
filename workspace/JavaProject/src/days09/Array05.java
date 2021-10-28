package days09;

public class Array05 {

	public static void main(String[] args) {
		// 배열에 있는 값들 중 최대값과 최소값을 찾아서 출력하자.
		int [] a = {56, 87, 96, 87, 45, 89, 69, 36, 13, 98};

		int max=a[0];	// 지금까지 나왔던 숫자들 중 가장 큰 값을 저장할 변수, 초기화를 0으로 하면 배열의 숫자가 전부 음수일때 난감해진다.
		for(int i=1;i<a.length;i++) {	// 일단 첫 max값이 a[0]이니 a[0]과 a[1]을 비교하는 작업부터 시작한다.
			if(max<a[i]) {
				max=a[i];
			}
		}
		System.out.println("최대값 : "+max);
		int min=a[0];
		for(int i=1;i<a.length;i++) {
			if(min>a[i]) {
				min=a[i];
			}
		}
		System.out.println("최소값 : "+min);
		
		
		// 배열의 값들을 오름차순 또는 내림차순으로 재배치(정렬)
		// 이중 반복문이 사용된다.
		// 첫 번째 반복문의 첨자 i
		// 두 번째 반복문의 첨자 j
		// i=0 일때 j는 1~9로 반복시켜서 a[i]와 a[j]를 비교하고, a[j]값이 더 작으면 a[i]와 a[j]의 값을 오름 차순에 맞게 맞바꾼다.
		// 그 동작을 j가 끝까지 갈때까지 반복하면 a[i]에는 배열중 가장 작은값이 저장되게 된다.
		// i=3 일떄 j는 4~9로 반복.
		
		for(int i=0;i<=9;i++) {
			for(int j=i+1;j<=9;j++) {
				if(a[i]>a[j]) {
					int a1 = a[i];
					a[i] = a[j];
					a[j] = a1;
				}
			}
//			System.out.printf("%d ",a[i]);	이렇게 써도 되고 아래 코드로 써도 된다.
		}
		for(int i=0;i<a.length;i++) {
			System.out.printf("%d ",a[i]);
		}
		System.out.println("-----------------------------\n");
		
		// 내림차순으로 진행하면?
		for(int i=0;i<=9;i++) {
			for(int j=i+1;j<=9;j++) {
				if(a[i]<a[j]) {	// 여기 부등호만 바꿔주면 내림차순으로 진행이 된다.
					int a1 = a[i];
					a[i] = a[j];
					a[j] = a1;
				}
			}
		}
		for(int i=0;i<a.length;i++) {
			System.out.printf("%d ",a[i]);
		}
	}
	
}
