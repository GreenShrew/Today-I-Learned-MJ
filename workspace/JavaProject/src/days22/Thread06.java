package days22;

import javax.swing.JOptionPane;

class ThreadE2 extends Thread{
	private boolean state = true;	// 스레드 실행여부를 판단할 변수 생성
	public void setState(boolean s) {		// 외부에서 호출할 수 있는 메소드를 만들었다.
		this.state=s;
	}
	public void run() {
		// 수시로 state 변수를 확인하면서 스레드 실행을 계속할지를 검사한다.
		for(int i=10;i>0&&this.state==true;i--) {
			System.out.println(i);
			try {
				sleep(1000);
			}catch(Exception e){
				
			}
		}
	}
}
// 스레드를 계속할지 아니면 멈출지를 결정할 boolean 변수가 멤버변수로 추가된다.
// 스레드를 계속 하려면 true, 멈추려면 false 로 값을 대입하는 setState 메소드도 추가된다.
// run 메소드는 실행 중간중간 또는 반복실행의 조건에서 state 변수가 true인지 검사한다.
// false이면 멈추고, true이면 계속한다.
public class Thread06 {

	public static void main(String[] args) {
		ThreadE2 t2 = new ThreadE2();
		t2.start();	// 스레드 시작
		String input = JOptionPane.showInputDialog("정답을 입력하세요");
		// 필요한 입력이 완료되면 스레드 실행중이더라도 state 값을 false로 바꿔줘서 멈추게 한다.
		t2.setState(false);
		// t2.stop()은 사용하지 않는다.
		System.out.println("입력하신 값은 "+input+"입니다.");
	}

}
