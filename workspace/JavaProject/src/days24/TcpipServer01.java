package days24;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpipServer01 {

	public static void main(String[] args) {
		// 서버 프로그램을 만들어보자.
		
		// 서버의 정보 설정
		ServerSocket ss = null;	// 서버를 여는 소켓이다.
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		try {
			ss = new ServerSocket(7777);
			System.out.println(f.format(new Date())+"서버가 준비되었습니다.");	// 서버가 언제 준비되었는지 '시분초' 가 나온다.
		}catch (IOException e) {
			System.out.println("서버 설정에 실패했습니다. 프로그램을 종료합니다.");
			return;
		}
		
		while(true) {	// 서버가 계속 돌아가게 while을 사용하였다.
			// 서버가 클라이언트의 요청을 기다리기 시작하는 명령
			try {
				System.out.println(f.format(new Date())+"연결 요청을 기다립니다.");	// 누군가 연결 요청을 기다리는 시간.
				Socket s = ss.accept();
				// 현재 명령에서 마치 sc.nextLine()이 사용자의 화면 입력을 기다리듯
				// 클라이언트의 연결 요청을 기다린다.
				// ServerSocket에 클라이언트의 연결 요청이 오면
				// 클라이언트 소켓과 서버에서 통신할 새로운 통신용 소켓을 클라이언트 정보를 이용하여 생성하고,
				// 소켓이 요청받은 클라이언트 연결 정보를 전달한다.
				// 이때, 서버에서 사용하는 통신소켓이 클라이언트의 정보를 이용하여 생성된다.
				// 여기서 말하는 클라이언트 정보라는 것은 클라이언트의 아이피와 포트번호, 출력권한 등 이다.
				System.out.println(f.format(new Date())+s.getInetAddress()+" 로부터 연결요청이 들어왔습니다.");
				// .getInetAddress() : 클라이언트의 아이피 주소를 추출하는 메소드
				
				// 클라이언트에게 메세지를 전송(출력)할 수 있는 권한을 Socket s로 부터 얻어서
				// OutputStream 객체에 저장한다.
				OutputStream out = s.getOutputStream();
				
				// 권한에 실제 출력 도구를 포함하려면 out을 생성자로 전달한 DataOutputStream 객체가 필요하다.
				DataOutputStream dos = new DataOutputStream(out);
				// 최종 통신 출력 도구 : dos
				
				// dos를 통해서 클라이언트에게 간단한 메세지를 전송한다.
				dos.writeUTF("[공지] 연결 성공! 204호 00변 서버에 접속되셨습니다.");
				
				System.out.println(f.format(new Date())+" 메세지를 전송했습니다.");
				dos.close();
				s.close();
				
			} catch (IOException e) {
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
