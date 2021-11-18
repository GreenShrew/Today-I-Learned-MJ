package days22;
// Thread : 프로그램의 명령을 실행하게끔 해주는 실행 주체.
// 개발자가 별도의 Thread를 생성하지 않는다면, 한 프로그램에 하나의 Thread가 존재하여 해당 명령을 차례차례 순서대로 실행시킨다.
// (일꾼 한명이 프로그램을 하나하나 작동시킨다)

// 동시 실행이 안 되는 예시
// 0.3초씩 쉬면서 순차적으로 결과값을 출력한다.

class ThreadA1{
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.printf("ThreadA1 : i -> %d\n",i);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class ThreadA2{
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.printf("ThreadA2 : i -> %d\n",i);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
public class Thread01 {

	public static void main(String[] args) {
		ThreadA1 t1 = new ThreadA1();
		ThreadA2 t2 = new ThreadA2();
		t1.run();
		t2.run();
		for(int i=1;i<=10;i++) {
			System.out.printf("main : i -> %d\n",i);try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
