package kr.co.jhchoi.cont;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import kr.co.jhchoi.domain.EmpBean;
import kr.co.jhchoi.model.EmpDao;

public class ServerStart {
	//Server Socket생성 메소드
	
	public void startSever(EmpBean eb){
		//서버생성위해 필요한것 : ip주소, 포트번호, 서버소켓
		ServerSocket ss = null;
		Socket socket = null;
		ObjectOutput oos = null;

		try {
			//서버구축으로 클라이언트로부터 응답대기
			ss = new ServerSocket();
			ss.bind(new InetSocketAddress("192.168.14.34", 50000));
			System.out.println("서버대기중");
			socket = ss.accept();			
			//클라이언트로 부터 요청이 오면, 자료 전송
			//EmpBean 자료 전달할 수 있도록 구성
			oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(eb);
			ss = new ServerSocket();
			System.out.println("oos세팅완료");
			oos.flush();
			System.out.println("oos전달완료");
			oos.close();
			socket.close();
			System.out.println("서버종료");
			ss.close();
			} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public EmpBean conServer(String ip, int port) {
		//Client가 서버에 접속하는 모듈
		Socket socket = new Socket();
		InetSocketAddress isa = new InetSocketAddress(ip, port);
		ObjectInputStream ois = null;
		try {
			//Client Server Socket에 연결시킴
			socket.connect(isa);
			//Server OuputStream 전달된 자료
			//InputStream 통해서 받아오기
			ois = new ObjectInputStream(socket.getInputStream());
			//eb에 서버에 접근한 데이터 받아오기
			EmpBean eb = (EmpBean)ois.readObject();
			ois.close();
			socket.close();
			
			return eb;			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void startSeverDB(){
		//서버생성위해 필요한것 : ip주소, 포트번호, 서버소켓
		ServerSocket ss = null;
		Socket socket = null;
		ObjectOutput oos = null;
		
		

		try {
			//서버구축으로 클라이언트로부터 응답대기
			ss = new ServerSocket();
			ss.bind(new InetSocketAddress("192.168.14.34", 50000));
			System.out.println("서버대기중");
			socket = ss.accept();			
			//클라이언트로 부터 요청이 오면, 자료 전송
			//EmpBean 자료 전달할 수 있도록 구성
			oos = new ObjectOutputStream(socket.getOutputStream());
			//Database에서부터 받아온 값을 입력			
			
			oos.writeObject(new EmpDao().getEmpAll());
			ss = new ServerSocket();
			System.out.println("oos세팅완료");
			oos.flush();
			System.out.println("oos전달완료");
			oos.close();
			socket.close();
			System.out.println("서버종료");
			ss.close();
			} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<EmpBean> conDBServer(String ip, int port) {
		//Client가 서버에 접속하는 모듈
		Socket socket = new Socket();
		InetSocketAddress isa = new InetSocketAddress(ip, port);
		ObjectInputStream ois = null;
		try {
			//Client Server Socket에 연결시킴
			socket.connect(isa);
			//Server OuputStream 전달된 자료
			//InputStream 통해서 받아오기
			ois = new ObjectInputStream(socket.getInputStream());
			
			List<EmpBean> al = (List<EmpBean>)ois.readObject();
			ois.close();
			socket.close();
			
			return al;			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
