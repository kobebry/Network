package kr.co.jhchoi.cont;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
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
				System.out.println("클라이언트로부터의 data : " + _clientData);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

public class MainRun {
	public static void main(String[] args) {
		InetAddress _ia = null;
		Socket _socket = null;
		Scanner sc = new Scanner(System.in);
		ServerThread st = null;
		
		try {
			_ia = InetAddress.getLocalHost();
		} catch (UnknownHostException e) { 
			e.printStackTrace();
		}
		int _userPort = 60606;
		ServerSocket _userSS = null;

		try {
			_userSS = new ServerSocket();
			_userSS.bind(new InetSocketAddress(_ia.getHostAddress(), _userPort));
			boolean a = true;
			byte[] _bytes = new byte[10000];

			while (a) {
				_socket = _userSS.accept();
				System.out.println("연결됨");
				
				st = new ServerThread(_socket);
				st.start();

				OutputStream _os = _socket.getOutputStream();
				String scvalue = null;
				do {
					scvalue = sc.nextLine();
					_bytes = scvalue.getBytes();
					_os.write(_bytes);
				} while (!scvalue.equals("exit"));				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				_userSS.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
