package days24;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpipServer02 {

	public static void main(String[] args) {
		
		ServerSocket ss = null;
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		
		
		try {
			ss = new ServerSocket(7777);
			System.out.println(f.format(new Date())+"서버가 준비되었습니다.");
		}catch (IOException e) {
			System.out.println("서버 설정에 실패했습니다. 프로그램을 종료합니다.");
			return;
		}
		
		while(true) {	// TcpipServer01과 똑같다. accpet 위에 setSoTimeout을 추가, 예외 추가
			try {
				System.out.println(f.format(new Date())+"연결 요청을 기다립니다.");	// 누군가 연결 요청을 기다리는 시간.
				
				ss.setSoTimeout(10000);	// 서버 소켓이 클라이언트 요청을 기다리는 시간 설정
				// 설정된 시간이 지날때까지 요청이 없으면 SocketTimeoutException 예외가 발생한다!
				
				Socket s = ss.accept();
				System.out.println(f.format(new Date())+s.getInetAddress()+" 로부터 연결요청이 들어왔습니다.");
				OutputStream out = s.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				dos.writeUTF("[공지] 연결 성공! 204호 00변 서버에 접속되셨습니다.");
				System.out.println(f.format(new Date())+" 메세지를 전송했습니다.");
				dos.close();
				s.close();
			} catch (SocketTimeoutException e) {
				System.out.println(f.format(new Date())+"접속시간 초과. 서비스를 종료합니다.");
				System.exit(0);	// return과 비슷한 프로그램 종료 명령
			}catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
