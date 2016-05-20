package kr.co.jhchoi.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import kr.co.jhchoi.domain.EmpBean;
import kr.co.jhchoi.model.EmpDao;

//EmpView Class -> 화면 구성 요소 객체
public class EmpView {

	// 1. 기본 메뉴 출력부분
	public void printMenu() {
		System.out.println("EMP 테스트 프로그램");
		System.out.println("원하는 메뉴를 선택하세요");
		System.out.println("1.사원입력");
		System.out.println("2.사원출력");
		System.out.println("3.서버구동");
		System.out.println("4.서버연결");
		System.out.println("5.DB서버구동");
		System.out.println("6.DB출력");
		System.out.println("q.프로그램종료");
	}

	// 메뉴입력 메소드
	public String inputMenu() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 써야될
																					// 버퍼메모리
																					// 읽기
		String inputMenu = "";
		try {
			inputMenu = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputMenu;
	}

	public EmpBean addEmp() {
		System.out.println("사원번호입력");
		int empno = Integer.parseInt(inputMenu());
		System.out.println("사원이름입력");
		String ename = inputMenu();
		System.out.println("매니저번호입력");
		int mgr = Integer.parseInt(inputMenu());
		System.out.println("업무를 입력");
		String job = inputMenu();
		System.out.println("입사일자를 입력");
		String hiredate = inputMenu();
		System.out.println("급여를 입력");
		int sal = Integer.parseInt(inputMenu());
		System.out.println("수당을 입력");
		int comm = Integer.parseInt(inputMenu());
		System.out.println("업무번호를 입력");
		int deptno = Integer.parseInt(inputMenu());

		EmpBean eb = new EmpBean();
		eb.setEmpno(empno);
		eb.setEname(ename);
		eb.setMgr(mgr);
		eb.setJob(job);
		eb.setHiredate(hiredate);
		eb.setSal(sal);
		eb.setComm(comm);
		eb.setDeptno(deptno);
		return eb;
	}

	public void printEmp(EmpBean eb) {
		System.out.println("1.사원번호 : " + eb.getEmpno());
		System.out.println("2.사원이름 : " + eb.getEname());
		System.out.println("3.매니저번호 : " + eb.getMgr());
		System.out.println("4.업무 : " + eb.getJob());
		System.out.println("5.입사일자 : " + eb.getHiredate());
		System.out.println("6.급여 : " + eb.getSal());
		System.out.println("7.수당 : " + eb.getComm());
		System.out.println("8.업무번호 : " + eb.getDeptno());
	}

	public void printEmpDB(List<EmpBean> al) {
		
		System.out.println("DB값 출력");
		System.out.println("사원번호/사원이름/매니저번호");
		System.out.println("================================");
		for(int i = 0; i < al.size(); i++){
			System.out.println(al.get(i).getEmpno()+"\t"+al.get(i).getEname()+"\t"+al.get(i).getMgr());
			
		}
		
	}
}
