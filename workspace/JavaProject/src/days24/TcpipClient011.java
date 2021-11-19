package days24;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpipClient011 {

	public static void main(String[] args) {
		
		String serverIp = "192.168.0.10";
		
		try {
			Socket s = new Socket(serverIp,7777);	// ���� ���� ����. ������ �����ϱ� ���ؼ��� ���� Ip �ּҿ� ��Ʈ��ȣ 7777�� ������Ѵ�.
			// Socket : Ŭ���̾�Ʈ�� ������ ��û�� ����Ʈ����
			// serverIp : Ŭ���̾�Ʈ�� ��û�� ������ �ּ�
			// 7777 : �������� ������ ������ �׷��ȣ
			// �ش� �����ǿ� ��Ʈ��ȣ�� ������ ������ ��Ʈ��ũ �� �־ ������ �����ϸ� �Ʒ� ������ ����. �����ϸ� catch ������ ����
			
			// ���Ͽ��� �Է� ��Ʈ���� ���޹޾� ����µ����� ���
			InputStream in = s.getInputStream();
			
			// InputStream �� �ܼ� �ƽ�Ű�ڵ� ������� �����ڿ� ���� ����Ŭ���̾�Ʈ ��ſ� 
			// ��� ������ ��Ʈ���� �����Ѵ�.
			DataInputStream dis = new DataInputStream(in);
			
			// ������ ��û�� �����κ��� ���޵� �޼����� �����Ѵ�.
			String m = dis.readUTF();
			
			// �������κ��� ���� �����͸� ����Ѵ�.
			System.out.println("���� �޽��� : "+m);
			System.out.println("������ �����մϴ�.");
			
			// ��Ʈ���� ������ �ݴ´�.
			dis.close();
			s.close();
			System.out.println("������ ����Ǿ����ϴ�.");
			
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
