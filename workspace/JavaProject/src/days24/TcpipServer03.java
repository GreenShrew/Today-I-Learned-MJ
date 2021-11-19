package days24;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class Sender extends Thread{
	Socket socket;
	DataOutputStream out;
	String name;
	Sender(Socket s){
		this.socket = s;
		try {
			out = new DataOutputStream(socket.getOutputStream());
			name = "["+socket.getInetAddress()+":"+socket.getPort()+"]";
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void run() {	// 서버에 접속되어 있는 한 입력되는 메세지를 전송하는 역할을 함
		Scanner sc = new Scanner(System.in);
		while(out!=null) {
			try {
				out.writeUTF(name+sc.nextLine());
				// 화면에 입력한 내용을 만들어둔 말머리와 함께 전송
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

class Receiver extends Thread{
	Socket socket;
	DataInputStream in;
	Receiver(Socket s){
		this.socket = s;
		try {
			in = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void run() {	// 읽어온걸 화면에 출력하는 일만 한다.
		while(in!=null) {
			try {
				System.out.println(in.readUTF());
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}

public class TcpipServer03 {

	public static void main(String[] args) {
		
		ServerSocket sS = null;
		Socket s = null;
		try {
			sS = new ServerSocket(5555);
			System.out.println("서버가 준비되었습니다. 연결을 기다립니다.");
			s = sS.accept();		// s에 연결 및 상대 클라이언트 정보 저장
			Sender sender =new Sender(s);
			Receiver receiver = new Receiver(s);	// 요청하는것도 전달 받는것도 소켓이 필요하니깐 이걸 전달인자로 만들어서 보낸다.
			sender.start();
			receiver.start();		// 여기서 main의 할 일은 끝났다. 요청을 받고 보내는 일은 위의 클래스에서 처리할 예정이기 떄문.
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
