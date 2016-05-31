package kr.co.jh.cont;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.jh.model.BoardDao;
import kr.co.jh.model.BoardDto;
import kr.co.jh.model.MemberDao;
import kr.co.jh.model.SetupDB;

/**
 * Servlet implementation class BoardReadCont
 */
@WebServlet("/read.do")
public class BoardReadCont extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		String p_code = request.getParameter("p_code");
		BoardDao bd = new BoardDao();
		BoardDto bDto = null;
		MemberDao md = new MemberDao();
		
		if (p_code == null) {
			String url = "login.jsp";
			move(request, response, url);
		}else if(p_code.equals("login")){
			
			System.out.println("여기");
			String b_id = request.getParameter("b_id");
			String b_pass = request.getParameter("b_pass");
			
			boolean chk = md.chkUser(b_id, b_pass);
			
			if(chk == true){
				p_code = "list";
				String url = "read.do";
				move(request, response, url);
			}
			
		
		} else if (p_code.equals("list")) {
			List<BoardDto> board_list = bd.getList();
			String url = "board_list.jsp";
			request.setAttribute("BL", board_list);
			move(request, response, url);

		} else if (p_code.equals("contents")) {
			String b_id = request.getParameter("b_id");
			// DB에 접근해 값을 가져오기			
			bDto = bd.getContents(b_id);
			String url = "read_contents.jsp";
			request.setAttribute("BDTO", bDto);
			move(request, response, url);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void move(HttpServletRequest req, HttpServletResponse resp, String url) {
		RequestDispatcher rd = req.getRequestDispatcher(url);
		try {
			rd.forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
