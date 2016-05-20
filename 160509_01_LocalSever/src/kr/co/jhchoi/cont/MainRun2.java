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
		// Server 원본 데이터
		String _serverData = "서버에 있는 데이터 값 입니다.";
		
		// IP주소갑 세팅
		InetAddress _ia = null;
		Socket _socket = null;

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
				//클라이언트에서 소켓연결이 성공되면 소켓이라는 객체에 넣어사용
				_socket = _userSS.accept(); // 대기상태
				count++;
				if (count > 10) {
					a = false;
				}
				System.out.println(count + "번째 누군가 접근했음");
				// Server -> Client = 원본 서버 자료를 클라이언트에 전달
				// OutputStream 데이터를 외부에 전달 시킴
				// Socket 객체를 통해 OutputStream 연결
				OutputStream _os = _socket.getOutputStream();
				// 일반 data를 byte단위로 변환시킨다.
				byte[] _bytes = new byte[300];
				// String 원본 값을 ->byte[] 저장하기, 데이터 쌓아 놓기
				_bytes = _serverData.getBytes();
				_os.write(_bytes);
				_os.flush();
				
				//클라이언트에서 부터 값 받아오기
				//InputStream
				InputStream _is = _socket.getInputStream();
				int _i = _is.read(_bytes);
				String _clientData = new String(_bytes, 0, _i);
				System.out.println("클라이언트로부터의 data : " + _clientData);
				_os.close();
				_is.close();
			}
			System.out.println("누군가 접근");
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
