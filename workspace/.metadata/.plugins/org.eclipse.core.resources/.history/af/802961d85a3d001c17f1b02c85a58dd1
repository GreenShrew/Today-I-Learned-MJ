package days11;

public class Method15 {

	public static void main(String[] args) {
		sort("asc",78,25,56,32,45,78,98);
		System.out.println();
		sort("desc",87,75,23,65,45,8,56,98,78,12);
	}
	// 같은형의 갯수가 정해지지 않은 전달인자와, 다른 자료형의 전달인자가 동시에 전달되어야 한다면,
	// 반드시 ... 으로 처리할 데이터들 보다 왼쪽에 전달되게 위치시킨다.
	public static void sort(String op,int...a) {		//(int...a, String op)라고 쓰면 문제가 생긴다.
		if(op.equals("asc:")) {
			for(int i=0;i<a.length;i++) {
				for(int j=i+1;j<a.length;j++) {
					if(a[i]>a[j]) {
						int temp = a[i];
						a[i] = a[j];
						a[j] = temp;
					}
				}
			}
		}else {
			for(int i=0;i<a.length;i++) {
				for(int j=i+1;j<a.length;j++) {
					if(a[i]<a[j]) {
						int temp = a[i];
						a[i] = a[j];
						a[j] = temp;
					}
				}
			}
		}		// 여기까지 배열의 앞이 'asc'면 오름차순, 아니면 내림차순으로 배열을 정렬하겠다는 의미.
		for(int i=0;i<a.length;i++) {
			System.out.printf("%d ",a[i]);
		}
	}
}
