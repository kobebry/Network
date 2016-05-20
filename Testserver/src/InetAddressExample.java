import java.net.InetAddress;

public class InetAddressExample {

	public static void main(String[] args) {
		try{
			InetAddress local = InetAddress.getLocalHost();
			System.out.println("내컴퓨터 IP주소 : " + local);
			
			InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com");
			for(InetAddress remote:iaArr){
				System.out.println("naver주소 : " + remote.getHostAddress());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
