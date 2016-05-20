package kr.co.jhchoi.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import kr.co.jhchoi.domain.EmpBean;

//EmpView Class -> 화면 구성 요소 객체
public class EmpView2 {

	//1. 기본 메뉴 출력부분
	public void printMenu(){
		System.out.println("EMP 테스트 프로그램");
		System.out.println("원하는 메뉴를 선택하세요");
		System.out.println("1.사원입력");
		System.out.println("2.사원출력");
		System.out.println("q.프로그램종료");
	}	
	//메뉴입력 메소드	
	public String inputMenu(){
		//InputStream is = System.in;
		//Reader reader = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //써야될 버퍼메모리 읽기
		String inputMenu = "";
		try {
			inputMenu = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}return inputMenu;
	}
	public EmpBean addEmp() {
		//사원추가 메뉴
		/*		String s_empno = Integer.toString(empno);//int타입을 String타입으로 변경
		double d_empno = Double.parseDouble(s_empno); //String타입을 Double타입으로 변경*/		
		System.out.println("사원번호를 입력하세요.");
		int empno = Integer.parseInt(inputMenu()); //String타입을 int타입으로 변경
		System.out.println("사원이름을 입력하세요");
		String ename = inputMenu();
		System.out.println("매니저번호를 입력하세요");
		int mgr = Integer.parseInt(inputMenu());
		
		EmpBean eb = new EmpBean();
		eb.setEmpno(empno);
		eb.setEname(ename);
		eb.setMgr(mgr);
		
		return eb;
		
	}
	public void printEmp(EmpBean eb) {
		System.out.print("사원번호는 : " + eb.getEmpno() + "," );
		System.out.print("사원이름은 : " + eb.getEname() + ",");
		System.out.print("매니저번호는 : " + eb.getMgr());
		System.out.println();
		
	}
}
