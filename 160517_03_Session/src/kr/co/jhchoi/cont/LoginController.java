package kr.co.jhchoi.cont;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.jhchoi.model.EmpDao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login Controller 실행됨");
		// 주 로그인 컨트롤러
		// p_code 값이 없으면
		String key = null;
		if(request.getParameter("p_code") == null){
			key = "def";
		}else{
			System.out.println("dddd");
			key = request.getParameter("p_code");
		}
		// 로그인이 안되있는 상태였을 때 처리방법
		if(key.equals("def")){
			System.out.println("Login Controller -> key = def 일 시 실행(로그인 안됨)");
			//로그인 화면 출력해주기
			String url = "login_form.jsp";
			move(request, response, url);			
		}else if(key.equals("login_chk")){
			//로그인 체크하기
			//login_form에서부터 p_empno, p_ename값 가져오기
			System.out.println("로그인 체크");
			String empno = request.getParameter("p_empno");
			String ename = request.getParameter("p_ename");
			
			//DB와 비교할 수 있도록 구성
			EmpDao ed = new EmpDao();
			// 로그인이 되었을 시에 처리방법
			int chk_id = ed.chk_id(empno, ename);
			if(chk_id == 1){
				//로그인 성공 페이지 출력
				//Session 값을 두고 empno를 세션에 삽입
				HttpSession hs = request.getSession();
				hs.setAttribute("empno", empno);
				request.setAttribute("ename", ename);
				move(request, response, "login_ok.jsp");				
			}else if(chk_id ==0){
				//로그인 실패 페이지 출력
				move(request, response, "login_form.jsp");
			}
		}else if(key.equals("log_out")){
			//로그아웃 처리
			HttpSession hs = request.getSession();
			hs.invalidate(); //세션삭제종료
			move(request, response, "login_form.jsp");
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	// Dispatch Forword
	private void move(HttpServletRequest request, HttpServletResponse response, String url){
		RequestDispatcher dis = request.getRequestDispatcher(url);
		try {
			dis.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
