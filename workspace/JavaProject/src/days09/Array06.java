package days09;

import java.util.Random;

public class Array06 {

	public static void main(String[] args) {
		// 로또 번호 발생기 프로그램을 만들어보자.
		int[] a = new int[6];
		Random rd = new Random();
		
		// 로또번호 6개 반복실행해서 저장
		for(int e=1;e<=5;e++) {
				for(int i=0;i<a.length;i++) {
					a[i]=rd.nextInt();
					if(a[i]<0) {
						a[i]*=-1;
					}
					a[i]=a[i]%45+1;	// 로또는 1~45 사이의 숫자! 0은 없다!
					
					int j;
					for(j=0;j<i;j++) {
						if(a[i]==a[j]) {
							break;
						}
					}
					if(i!=j) {	// 중복값이 없다면 i와 j는 같지만, 중복값이 있어 위 for문이 중간에 중단되면 이 if문이 실행된다.
						i--;		// 굉장히 위험한 행위! 반복문이 끝나지 않을 수 있다.
					}
				}
				System.out.println();
				
				for(int i=0;i<a.length;i++) {
					for(int j=i+1;j<a.length;j++) {
						if(a[i]>a[j]) {
							int x=a[i];
							a[i]=a[j];
							a[j]=x;
						}
					}
					System.out.printf("%d ",a[i]);
				}
				System.out.println();
		}
	}
	
}
