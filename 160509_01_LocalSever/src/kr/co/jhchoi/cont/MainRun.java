package kr.co.jhchoi.cont;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;

public class MainRun {
	public static void main(String[] args) {
		// IP주소갑 세틩
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
		int _userPort = 60606;

		// Server Socket 구성
		ServerSocket _userSS = null;
		try {
			_userSS = new ServerSocket();
			// Socket 구성 시 필요 요소 : IP주소, Port
			_userSS.bind(new InetSocketAddress(_ia.getHostAddress(), _userPort));
			// 구성된 ServerSocket Open
			int count = 0;
			boolean a = true;
			while (a) {
				_userSS.accept(); // 대기상태
				count++;
				if (count > 10) {
					a = false;
				}
				System.out.println(count + "번째 누군가 접근했음");
			}
			System.out.println("누군가 접근");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
