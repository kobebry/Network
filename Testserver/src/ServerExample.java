import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {

	public static void main(String[] args) {
		ServerSocket ssocket = null;
		
		try{
			ssocket = new ServerSocket();
			ssocket.bind(new InetSocketAddress("localhost", 5001));
			while(true){
				System.out.println("연결기다림");
				Socket socket = ssocket.accept(); //연결 수락
				InetSocketAddress isa = (InetSocketAddress)socket.getRemoteSocketAddress();
				System.out.println("연결 수락함" + isa.getHostName());
			}
			
		}catch(Exception e){
			if(!ssocket.isClosed()){
				try{
					ssocket.close();
				}catch(IOException e1){
					
				}
			}
		}
			
	}

}
