package kr.co.jhchoi.cont;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainRun2 {
	public static void main(String[] args) {
		// Server ���� ������
		String _serverData = "������ �ִ� ������ �� �Դϴ�.";
		
		// IP�ּҰ� ����
		InetAddress _ia = null;
		Socket _socket = null;

		try {
			_ia = InetAddress.getLocalHost();// ����ǻ�ͷ� ȣ��Ʈ��
		} catch (UnknownHostException e) { // IP�ּ� ������ �ȵ������� ���ܹ߻�
			e.printStackTrace();
		}
		System.out.println(_ia.getHostName()); // ȣ��Ʈ�̸�
		System.out.println(_ia.getHostAddress());// ȣ��Ʈ�ּ�
		// Port ��ȣ ����
		// 0~65535 ��Ʈ��ȣ ��������
		// 60606
		int _userPort = 60606;

		// Server Socket ����
		ServerSocket _userSS = null;

		try {
			_userSS = new ServerSocket();
			// Socket ���� �� �ʿ� ��� : IP�ּ�, Port
			_userSS.bind(new InetSocketAddress(_ia.getHostAddress(), _userPort));
			// ������ ServerSocket Open
			int count = 0;
			boolean a = true;
			while (a) {
				//Ŭ���̾�Ʈ���� ���Ͽ����� �����Ǹ� �����̶�� ��ü�� �־���
				_socket = _userSS.accept(); // ������
				count++;
				if (count > 10) {
					a = false;
				}
				System.out.println(count + "��° ������ ��������");
				// Server -> Client = ���� ���� �ڷḦ Ŭ���̾�Ʈ�� ����
				// OutputStream �����͸� �ܺο� ���� ��Ŵ
				// Socket ��ü�� ���� OutputStream ����
				OutputStream _os = _socket.getOutputStream();
				// �Ϲ� data�� byte������ ��ȯ��Ų��.
				byte[] _bytes = new byte[300];
				// String ���� ���� ->byte[] �����ϱ�, ������ �׾� ����
				_bytes = _serverData.getBytes();
				_os.write(_bytes);
				_os.flush();
				
				//Ŭ���̾�Ʈ���� ���� �� �޾ƿ���
				//InputStream
				InputStream _is = _socket.getInputStream();
				int _i = _is.read(_bytes);
				String _clientData = new String(_bytes, 0, _i);
				System.out.println("Ŭ���̾�Ʈ�κ����� data : " + _clientData);
				_os.close();
				_is.close();
			}
			System.out.println("������ ����");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				_userSS.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
