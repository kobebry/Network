package kr.co.jhchoi.cont;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

class ServerThread extends Thread {
	Socket _socket;

	ServerThread(Socket _socket) {
		this._socket = _socket;
	}

	public void run() {
		InputStream _is;
		try {
			_is = _socket.getInputStream();
			byte[] _bytes = new byte[10000];

			while (true) {

				int readS = _is.read(_bytes);
				String _clientData;
				_clientData = new String(_bytes, 0, readS);
				if (_clientData.equals("exit")) {
					break;
				}

				System.out.println("�����κ��� ���� data : " + _clientData);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

public class MainRun {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		InetAddress _ia = null;
		try {
			_ia = InetAddress.getLocalHost();// ����ǻ�ͷ� ȣ��Ʈ��
		} catch (UnknownHostException e) { // IP�ּ� ������ �ȵ������� ���ܹ߻�
			e.printStackTrace();
		}
		System.out.println(_ia.getHostName()); // ȣ��Ʈ�̸�
		System.out.println(_ia.getHostAddress());// ȣ��Ʈ�ּ�

		int _userPort = 60600;
		String _serverIP = "192.168.14.34";
		int _serverPort = 60606;

		Socket _socket = null;
		ServerThread st = null;

		try {
			_socket = new Socket();
			_socket.connect(new InetSocketAddress(_serverIP, _serverPort));
			System.out.println("�������Ӽ���");
			st = new ServerThread(_socket);
			st.start();

			byte[] _bytes = new byte[300];
			OutputStream _os = _socket.getOutputStream();
			String scvalue = null;
			do {
				scvalue = sc.nextLine();
				_bytes = scvalue.getBytes();
				_os.write(_bytes);
			} while (!scvalue.equals("exit"));

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				_socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
