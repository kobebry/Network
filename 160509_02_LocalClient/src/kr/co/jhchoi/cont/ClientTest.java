package kr.co.jhchoi.cont;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Socket socket = null;
		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress("192.168.14.34", 8805));
			System.out.println("연결 성공");

			
			String message = null;
			
			byte[] bytes = new byte[10000];
			do{
				OutputStream os = socket.getOutputStream();
				message = sc.nextLine();			
				bytes = message.getBytes();
				os.write(bytes);
				os.flush();
			}while(!message.equals("exit"));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

}
