package kr.co.jhchoi.cont;

import java.util.List;

import kr.co.jhchoi.domain.EmpBean;
import kr.co.jhchoi.model.EmpDao;
import kr.co.jhchoi.view.EmpView;

public class EmpMainRun {

	public static void main(String[] args) {
		String input;
		EmpView ev = new EmpView();
		EmpBean eb = new EmpBean();
		ServerStart ss = new ServerStart();

		do{
		ev.printMenu();
		input = ev.inputMenu();
		
		if(input.equals("1")){
			eb = ev.addEmp();
		}else if(input.equals("2")){
			ev.printEmp(eb);
		}else if(input.equals("3")){
			// 3 = Server로 Socket을 생성해서 대기
			// 클라이언트에게 입력한 Emp정보를 제공
			ss.startSever(eb);
		}else if(input.equals("4")){
			// 4 = 해당서버에 접근하여
			// 서버 OutputStream에 있는 값을
			// InputStrea을 통해서 받아오기
			String ip = ev.inputMenu();
			int port = Integer.parseInt(ev.inputMenu());
			eb = ss.conServer(ip,port);
			ev.printEmp(eb);
		}else if(input.equals("5")){
			//5. DB자료형 서버 열기
			ss.startSeverDB();
		}else if(input.equals("6")){
			//6. DB자료 받아오기
			//ev.printDB();
			String ip = ev.inputMenu();
			int port = Integer.parseInt(ev.inputMenu());
			List<EmpBean> al = ss.conDBServer(ip, port);
			ev.printEmpDB(al);
		
		}
		}while(!input.equals("q"));		
	}
}
