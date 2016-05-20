package kr.co.jhchoi.cont;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/admin.do")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AdminController 실행");
		//adm_id, adm_pass, adm_code(Controller 조작 값)
		String adm_code = request.getParameter("adm_code");
		
		if(adm_code.equals("adm_login")){
			//로그인 버튼 눌렀을 시 처리
			String adm_id = request.getParameter("adm_id");
			String adm_pass = request.getParameter("adm_pass");
			
		if(!adm_id.equals("admin")){
			response.sendRedirect(request.getContextPath()+"/JSP/admin/admin_login_chk.jsp");
			
			}else{RequestDispatcher dis = request.getRequestDispatcher("/JSP/admin/admin_login_chk.jsp"); //가고자하는 웹페이지에 주소값
			
			request.setAttribute("adm_id", adm_id); //웹을 다른 웹으로 전달할 하기 위해 값을 저장한다.
			request.setAttribute("adm_pass", adm_pass); //adm_pass 값을 adm_pass값으로 저장한다.
			dis.forward(request, response); //
			
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
