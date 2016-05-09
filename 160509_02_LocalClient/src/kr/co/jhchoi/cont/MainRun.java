package kr.co.jhchoi.cont;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainRun {

	public static void main(String[] args) {
		// Client Program
		// 클라이언트는 일반 Socket API를 사용
		InetAddress _ia = null;
		try {
			_ia = InetAddress.getLocalHost();// 내컴퓨터로 호스트값
		} catch (UnknownHostException e) { // IP주소 세팅이 안되있으면 예외발생
			e.printStackTrace();
		}
		System.out.println(_ia.getHostName()); // 호스트이름
		System.out.println(_ia.getHostAddress());// 호스트주소
		// Port 번호 생성
		// 0~65535 포트번호 지정가능
		// 60606
		int _userPort = 60602;
		
		// Socket API 서버에 접근할 수 있도록 구성
		// 서버 주소 및 포트값 지정
		String _serverIP = "192.168.14.27";
		int _serverPort = 60606;
		
		Socket _socket = null;
		try {
			//접근하려는 서버IP, Port 세팅
			//_socket = new Socket(_serverIP, _serverPort);
			_socket = new Socket();
			_socket.connect(new InetSocketAddress(_serverIP, _serverPort));
			System.out.println("서버접속성공");
			_socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
