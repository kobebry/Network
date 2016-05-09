package kr.co.jhchoi.cont;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;

public class MainRun {
	public static void main(String[] args) {
		// IP�ּҰ� ����
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
				_userSS.accept(); // ������
				count++;
				if (count > 10) {
					a = false;
				}
				System.out.println(count + "��° ������ ��������");
			}
			System.out.println("������ ����");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
