package kr.co.jhchoi.cont;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainRun {

	public static void main(String[] args) {
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
		int _userPort = 60602;
		
		// Socket API ������ ������ �� �ֵ��� ����
		// ���� �ּ� �� ��Ʈ�� ����
		String _serverIP = "192.168.14.27";
		int _serverPort = 60606;
		
		Socket _socket = null;
		try {
			//�����Ϸ��� ����IP, Port ����
			//_socket = new Socket(_serverIP, _serverPort);
			_socket = new Socket();
			_socket.connect(new InetSocketAddress(_serverIP, _serverPort));
			System.out.println("�������Ӽ���");
			_socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
