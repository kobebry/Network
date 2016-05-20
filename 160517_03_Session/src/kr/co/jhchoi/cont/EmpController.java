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
import kr.co.jhchoi.model.EmpDto;

/**
 * Servlet implementation class EmpController
 */
@WebServlet("/Emp.do")
public class EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. Session -> empno
		HttpSession hs = request.getSession();
		if(hs.getAttribute("empno")==null){
			//세션에 EMPNO가 없으면
			//로그인 할 수 있는 페이지로 전달
			response.sendRedirect("/login.do");
		}else{
			//세션값이 존재함
			//code값에 따라 Controller 실행될 수 있도록 구성
			String code = "def";

			if(!request.getParameter("p_code").equals("")){
				code = request.getParameter("p_code");
			}			

			if(code.equals("def")){
				//회원정보 수정 할 수 있도록 함
				System.out.println("EmpController 실행 -> 회원정보 수정 Controller 실행");
				String empno = hs.getAttribute("empno").toString();
				//Empno 값을 통해 무엇을 해야함?
				//DB접속해서 Update할 수 있도록 구성
				EmpDao ed = new EmpDao();
				//Empno 사원의 자료값 받아올 수 있도록 구성
				EmpDto eb = new EmpDto();
				eb = ed.getEmp(empno);
				// eb => JSP에 전달
				request.setAttribute("eb", eb);
				RequestDispatcher rd = request.getRequestDispatcher("modify_emp.jsp");
				rd.forward(request, response);				
			}else if(code.equals("emp_update")){
				//자료 받아서 Update처리
				EmpDto ed = new EmpDto();
				ed.setEmployee_id(Integer.parseInt(request.getParameter("p_empno")));
				ed.setFirst_name(request.getParameter("p_fname"));
				ed.setLast_name(request.getParameter("p_lname"));
				ed.setPhone_number(request.getParameter("p_pnum"));
				ed.setEmail(request.getParameter("p_mail"));
				ed.setHire_date(request.getParameter("p_date"));
				ed.setSalary(Integer.parseInt(request.getParameter("p_salary")));
				ed.setCommission_pct(Integer.parseInt(request.getParameter("p_compct")));
				ed.setManager_id(Integer.parseInt(request.getParameter("p_mgr")));
				ed.setJob_id(request.getParameter("p_jobid"));
				//변경된 ED값 세팅
				//Dao => Update문 쿼리 실행
				EmpDao edao = new EmpDao();
				int cnt = edao.modEmp(ed);
				//몇건의 데이터가 수정되었습니다.
				request.setAttribute("cnt", cnt);
				RequestDispatcher dis = request.getRequestDispatcher("emp_mod_ok.jsp");
				dis.forward(request, response);
			}				
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
