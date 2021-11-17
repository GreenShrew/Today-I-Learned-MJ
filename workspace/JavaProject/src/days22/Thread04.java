package days22;

// # 2번 방식
// Runnable 인터페이스를 구현하는 방법
// 2-1. Runnable 인터페이스를 구현하는 클래스 작성
// 2-2. public void run() 오버라이딩 구현
// 2-3. 해당 클래스의 A 객체 생성
// 2-4. A 객체를 Thread 클래스의 생성자로 전달하여 Thread 객체 생성
// 2-5. 생성시킨 쓰레드의 start 메소드를 호출

// 이 방법은 실행하는 방식만 살짝 다를 뿐, 역할은 같다.
class ThreadD1 implements Runnable{
	public void run() {	
		for(int i=10;i>0;i--) {
			System.out.printf("ThreadD1 : i -> %d\n",i);
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class ThreadD2 implements Runnable{
	public void run() {	
		for(int i=10;i>0;i--) {
			System.out.printf("ThreadD2 : i -> %d\n",i);
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
public class Thread04 {

	public static void main(String[] args) {
		// Runnable 인터페이스를 구현한 쓰레드 생성
		// 1. Runnable 인터페이스를 구현한 클래스의 객체 생성
		ThreadD1 t1 = new ThreadD1();
		// 2. 1에서 생성된 객체를 Thread 생성자에 전달인수로 전달하며 Thread 객체 생성
		Thread t = new Thread(t1);
		// 3. 2에서 생성된 Thread 객체를 사용하여 start 메소드 호출
		t.start();
		
		// 위의 과정을 한 라인으로 작성한 코드
		new Thread(new ThreadD2()).start();
		
		for(int i=10;i>0;i--) {
			System.out.printf("main : i -> %d\n",i);
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
