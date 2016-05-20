package kr.co.jhchoi.cont;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {

	public static void main(String[] args) {
		ServerSocket server = null;
		Socket socket = null;

		try {

			server = new ServerSocket();
			server.bind(new InetSocketAddress("192.168.14.34", 8805));

			System.out.println("연결 기다림");
			socket = server.accept();
			System.out.println("연결됨");

			byte[] bytes = null;
			String clientdata = null;
			
			while (true) {
				bytes = new byte[10000];
				InputStream is = socket.getInputStream();
				int read = is.read(bytes);
				clientdata = new String(bytes, 0, read);

				if (clientdata.equals("exit")) {
					break;
				}
				System.out.println(clientdata);
			}
		

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
