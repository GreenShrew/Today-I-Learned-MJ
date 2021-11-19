package days24;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpipClient03 {

	public static void main(String[] args) {
		String serverIp = "192.168.0.10";
		
		try {
			Socket s = new Socket(serverIp,5555);
			System.out.println("서버에 연결되었습니다.");
			Sender sender =new Sender(s);
			Receiver receiver = new Receiver(s);
			// TcpipServer03과 같은 패키지 안에 있으므로, Sender, Receiver 클래스를 사용할 수 있다.
			sender.start();
			receiver.start();
		}catch (UnknownHostException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
