package days24;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.util.Scanner;

public class TcpipClient031 {

	public static void main(String[] args) {
		String serverIp = "192.168.0.10";
		
		try {
			Socket s = new Socket(serverIp,5555);
			System.out.println("������ ����Ǿ����ϴ�.");
			Sender sender =new Sender(s);
			Receiver receiver = new Receiver(s);
			// TcpipServer03�� ���� ��Ű�� �ȿ� �����Ƿ�, Sender, Receiver Ŭ������ ����� �� �ִ�.
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
