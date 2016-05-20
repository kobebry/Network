package kr.co.jhchoi.cont;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 138691296896492888L;

	@Override
	public void init() throws ServletException {
		//서블릿 초기화 메소드(시작할 때 1번만 구동)
		System.out.println("서블릿 1회 실행");		
		super.init();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Client가 요청했을 시 구동되는 메소드
		System.out.println(req.getRemoteHost()+" 접근");
		System.out.println("Service 실행");
		PrintWriter out = resp.getWriter();
		out.println("<html><head></head><body>"+req.getRemoteHost()+"</body></html>");
	}
	@Override
	public void destroy() {
		// Servlet 종료 시에 한번 구동
		// WAS가 종료될 시
		System.out.println("Servlet 종료");
		super.destroy();
	}

	
}
