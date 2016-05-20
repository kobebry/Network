package kr.co.jhchoi.cont;

import kr.co.jhchoi.domain.EmpBean;
import kr.co.jhchoi.view.EmpView;

public class EmpMainRun2 {

	public static void main(String[] args) {
		String input;
		EmpBean eb = new EmpBean();
		EmpView ev = new EmpView();
		do {
			// menu 출력하기
			ev.printMenu();
			// Menu 입력하기
			input = ev.inputMenu();
			// 해당메뉴에 따라서 출력
			if (input.equals("1")) {
				// 사원 입력할 수 있는 메뉴 출력
				eb = ev.addEmp();
			} else if (input.equals("2")) {
				// 입력된 사원 출력하기
				// eb => EmpView 사원정보 출력
				// ev.printEmp(eb);
				ev.printEmp(eb);
				
			}
		} while (!input.equals("q"));
	}

}
