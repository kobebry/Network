package kr.co.jhchoi.cont;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhchoi.model.BoardDao;
import kr.co.jhchoi.model.BoardDto;

/**
 * Servlet implementation class BoardWriteCont
 */
@WebServlet("/write.do")
public class BoardWriteCont extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DB에 실제 값을 전달하여 입력할 수 있는 기능의 컨트롤러
		//DML 문 실행 시 접근할  컨트롤러
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		String p_code = request.getParameter("p_code");

		if(p_code.equals("write_ok")){
			// board_input.jsp에서 받아 올 파라미터값을 세팅하여 Dao를 통해 실행
			BoardDto bDto = new BoardDto();
			bDto.setTitle(request.getParameter("title"));
			bDto.setWriter(request.getParameter("writer"));
			bDto.setPassword(request.getParameter("password"));
			bDto.setPds_link(request.getParameter("pds_link"));
			bDto.setContents(request.getParameter("contents"));
			
			//bDto를 DAO 전달 한 후 DB전송
			BoardDao bd = new BoardDao();
			int chk = bd.writeContents(bDto);
			//글목록으로 이동
			if(chk ==1){
				move(request, response, "read.do?p_code=list");
			}		
		}else if(p_code.equals("modify_ok")){
			BoardDto bDto = new BoardDto();
			bDto.setTitle(request.getParameter("title"));
			bDto.setWriter(request.getParameter("writer"));
			bDto.setPassword(request.getParameter("password"));
			bDto.setPds_link(request.getParameter("pds_link"));
			bDto.setContents(request.getParameter("contents"));
			bDto.setBoard_id(Integer.parseInt(request.getParameter("p_bid")));
			
			//수정될 값 DAO에 전달
			BoardDao bd = new BoardDao();
			int chk = bd.modifyContents(bDto);
			if(chk ==1){
				move(request, response, "read.do?p_code=contents&b_id="+bDto.getBoard_id());
			}	
			
		}else if(p_code.equals("delete_ok")){
			BoardDto bDto = new BoardDto();
			//bDto.setBoard_id(request.getParameter("board_id"));
			bDto.setPassword(request.getParameter("password"));
			bDto.setBoard_id(Integer.parseInt(request.getParameter("p_bid")));
			
			BoardDao bd = new BoardDao();			
/*			String password = bd.getPassword(bDto.getBoard_id());
			
			bDto.getPassword();*/
			
			int chk = bd.deleteContents(bDto);			
			if(chk ==1){
				move(request, response, "read.do?p_code=list");
			}else{
				move(request, response, "read.do?p_code=delete&error=ok");
			}
		}else if(p_code.equals("list")){
			move(request, response, "read.do?p_code=list");
		}
	}
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
