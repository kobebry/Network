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
		String _clientData = "클라이언트 데이터 입니다.";
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
		int _userPort = 60600;
		
		// Socket API 서버에 접근할 수 있도록 구성
		// 서버 주소 및 포트값 지정
		String _serverIP = "192.168.14.34";
		int _serverPort = 60606;
		
		Socket _socket = null;
		try {
			//접근하려는 서버IP, Port 세팅
			//_socket = new Socket(_serverIP, _serverPort);
			_socket = new Socket();
			_socket.connect(new InetSocketAddress(_serverIP, _serverPort));
			System.out.println("서버접속성공");
			// 서버에 OutputStream에 있는 값을 가져오기
			InputStream _is = _socket.getInputStream();
			byte[] _bytes = new byte[300];
			int _i = _is.read(_bytes); // inputstream안에 들어가 있는 내용
			String _serverdata = new String(_bytes, 0, _i); //0부터 _i에 있는 내용을 조합해 String으로 사용
			System.out.println("서버에서 부터 받은 값 : " + _serverdata);
			//서버쪽으로 전달
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
