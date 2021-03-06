package days22;

// 프로그램의 수행 중 동시에 처리하고자 하는 작업이 생겼을때는 
// 원래 갖고 있는 메인 Thread 외에 Thread 클래스를 추가 사용하여 실행시킬 수 있다.
// Thread Class : 프로그램 실행의 흐름은 분기할 수 있는 방법을 제공하는 클래스.

// 구현방법
// 1. Thread 클래스를 상속받는 방법.
//		1-1.	Thread 클래스를 상속받아 public void run() 메소드를 오버라이딩한다.
//				public void run() : 쓰레드가 생성되어 수행할 작업을 정의하는 메소드
//		1-2.	해당 클래스의 객체를 생성하고, start 메소드를 호출(실행)한다.
//				만약 오버라이딩된 run 메소드를 호출하면, 쓰레드 생성실행이 아니라, 일반 메소드 호출이 되므로
//				반드시 strat 메소드를 통해 run 으로 이어지게 호출한다.
//				start 메소드 : Thread 클래스(부모 클래스)에 있는 메소드로, 자체적으로 쓰레드 추가 생성 후
//								run 메소드를 재호출하는 역할을 한다.
//								(상속된 메소드로 메소다가 표면에 보여지지는 않은채 사용된다)
// 2. Runnable 인터페이스를 implements(구현)하는 방법.
//		2-1. Thread 클래스를 상속하는 방법과 같고, 효과도 거의 같다.

// # 1번 방식
// 프로그램이 실행되면 동시에 연산을 하여 결과를 출력한다.
class ThreadB1 extends Thread{
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.printf("ThreadB1 : i -> %d\n",i);
			try {
				Thread.sleep(300);	// 0.3초간 멈췄다 가도록 만드는 메소드 sleep
				sleep(300);
				// sleep 메소드는 Thread 클래스에 있는 static 메소드이다.
				// 사용할 때 Thread.sleep()으로 사용해야 하지만, 현재 위치는 자기 자신의 클래스 내부이기도 하므로,
				// 위 처럼 sleep()으로만 사용해도 된다.
				// 또한, 프로세서 실행에 관여하는 명령이라서 예외처리가 따라다닌다.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class ThreadB2 extends Thread{
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.printf("ThreadB2 : i -> %d\n",i);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
public class Thread02 {

	public static void main(String[] args) {
		ThreadB1 b1 = new ThreadB1();
		ThreadB2 b2 = new ThreadB2();
//		b1.run();	이렇게 하면 아까전이랑 다를게 없다
		b1.start();
		b2.start();
		for(int i=1;i<=10;i++) {
			System.out.printf("main : i -> %d\n",i);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
