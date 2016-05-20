package kr.co.jhchoi.cont;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jhchoi.model.BoardDto;
import kr.co.jhchoi.model.BoardDao;

/**
 * Servlet implementation class BoardReadCont
 */
@WebServlet("/read.do")
public class BoardReadCont extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Code값 호출
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		String p_code = request.getParameter("p_code");

		
		//1. 글목록 호출(list)
		if(p_code.equals("list")){
			//DB에 접금하여 database에 전체 값 받아오기
			BoardDao bd = new BoardDao();
			//쿼리문을 통해 Board Table값 받아 오기
			//전체 Board Table 글번호, 제목값, 작성자, 작성시간, 추천수, 조회수
			List<BoardDto> board_list = bd.getList();
			String url = "board_list.jsp";
			request.setAttribute("BL", board_list);
			move(request, response, url);			
		}else if(p_code.equals("contents")){
			//2.해당게시물 출력할 수 있도록 구성
			//선택한 게시글의 b_id 불러오기
			String b_id = request.getParameter("b_id");
			//DB접근해서 게시글 내용 받아오기
			BoardDto bDto = null;
			BoardDao bd = new BoardDao();
			bDto = bd.getContents(b_id);
			//DB 가져온 bDto jsp에 출력
			//board_view.jsp			
			request.setAttribute("BDTO", bDto);
			move(request, response, "board_view.jsp");			
		}else if(p_code.equals("write")){
			//글 작성할 수 있는 페이지 호출
			move(request, response, "board_input.jsp");
		}else if(p_code.equals("modify")){
			String b_id = request.getParameter("p_bid");
			//DB에 접근해서 b_id를 통한 값 받아오기
			BoardDao bDao = new BoardDao();
			BoardDto bDto = bDao.getContents(b_id);
			//DB에서 가져온 bDto값을 수정페이지에 전달
			request.setAttribute("BDTO", bDto);
			//request.setAttribute("MODIFY", "modify"); //view page에서 수정페이지로 활용할 내용이나 선택
			move(request, response, "board_input.jsp");		
		}else if(p_code.equals("delete")){			
			String b_id = request.getParameter("p_bid");
			request.setAttribute("BID", b_id);
			request.setAttribute("error", request.getParameter("error"));
			move(request, response, "board_delete.jsp");			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void move(HttpServletRequest req, HttpServletResponse resp, String url){
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