package kr.co.jhchoi.cont;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/subcont.do")

public class SubController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3851853577135911284L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		
		writer.println("1. 아이디 : " + req.getParameter("a_id")+"<br>");
		writer.println("2. 비밀번호 : " + req.getParameter("a_pass")+"<br>");
		writer.println("3. 이름 : " + req.getParameter("a_name")+"<br>");
		writer.println("4. 성별 : " + req.getParameter("gender")+"<br>");
		writer.println("5. 생년월일 : " + req.getParameter("a_birth_y")+req.getParameter("a_birth_d")+req.getParameter("a_combo")+"<br>");
		writer.println("6. 주소 : " + req.getParameter("a_address"));
		/*
		writer.println("클라이언트 IP : "+req.getRemoteAddr());
		writer.println("요청정보길이 : "+req.getContentLength());
		writer.println("요청정보 인코딩 : "+req.getCharacterEncoding());
		writer.println("요청정보 컨텍트타입 : "+req.getContentType());
		writer.println("요청정보 프로토콜 타입 : "+ req.getProtocol());
		writer.println("정보전송 방식 + " + req.getMethod());
		writer.println("요정한 URL 경로 : " + req.getRequestURI());
		writer.println("컨텍스트 경로 : "+ req.getContextPath());
		writer.println("서버이름 : "+req.getServerName());
		writer.println("포트번호 : "+req.getServerPort());*/
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req,resp);
	}
}
