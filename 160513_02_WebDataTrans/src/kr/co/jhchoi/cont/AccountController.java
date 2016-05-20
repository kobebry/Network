package kr.co.jhchoi.cont;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AccountController
 */
@WebServlet("/jk.do")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a_code = request.getParameter("a_code");
		
		if(a_code.equals("a_login")){
			String a_id = request.getParameter("a_id");
			String a_pass = request.getParameter("a_pass");
			String a_name = request.getParameter("a_name");
			String gender = request.getParameter("gender");
			String a_birth_y = request.getParameter("a_birth_y");
			String a_combo = request.getParameter("a_combo");
			String a_birth_d = request.getParameter("a_birth_d");
			String a_address = request.getParameter("a_address");
			
			RequestDispatcher dis = request.getRequestDispatcher("/JSP/account/account_submit.jsp");
			request.setAttribute("a_id", a_id);
			request.setAttribute("a_pass", a_pass);
			request.setAttribute("a_name", a_name);
			request.setAttribute("gender", gender);
			request.setAttribute("a_birth_y", a_birth_y);
			request.setAttribute("a_combo", a_combo);
			request.setAttribute("a_birth_d", a_birth_d);
			request.setAttribute("a_address", a_address);
			dis.forward(request, response);
			
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
