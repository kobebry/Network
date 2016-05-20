package kr.co.jhchoi.cont;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainRun2 {

	public static void main(String[] args) {
		String _clientData = "Ŭ���̾�Ʈ ������ �Դϴ�.";
		// Client Program
		// Ŭ���̾�Ʈ�� �Ϲ� Socket API�� ���
		InetAddress _ia = null;
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
		int _userPort = 60600;
		
		// Socket API ������ ������ �� �ֵ��� ����
		// ���� �ּ� �� ��Ʈ�� ����
		String _serverIP = "192.168.14.34";
		int _serverPort = 60606;
		
		Socket _socket = null;
		try {
			//�����Ϸ��� ����IP, Port ����
			//_socket = new Socket(_serverIP, _serverPort);
			_socket = new Socket();
			_socket.connect(new InetSocketAddress(_serverIP, _serverPort));
			System.out.println("�������Ӽ���");
			// ������ OutputStream�� �ִ� ���� ��������
			InputStream _is = _socket.getInputStream();
			byte[] _bytes = new byte[300];
			int _i = _is.read(_bytes); // inputstream�ȿ� �� �ִ� ����
			String _serverdata = new String(_bytes, 0, _i); //0���� _i�� �ִ� ������ ������ String���� ���
			System.out.println("�������� ���� ���� �� : " + _serverdata);
			//���������� ����
			OutputStream _os = _socket.getOutputStream();
			_bytes = _clientData.getBytes();
			_os.write(_bytes);			
			_os.flush();
			_is.close();
			_os.close();
			_socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
