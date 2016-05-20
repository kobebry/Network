package kr.co.jhchoi.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {

	public List<BoardDto> getList() {
		//DB값에서 게시글 목록 불러오기
		//board_id, title, writer, wdate, cont_like, read_cnt
		SetupDB sd = new SetupDB();
		String sql= "SELECT board_id, title, writer, read_cnt, TO_CHAR(wdate, 'YYYY-MM-DD HH:MI:SS'), cont_like FROM KITRI_BOARD WHERE use_yn = 'Y' ORDER BY BOARD_ID DESC";		
		ResultSet rs = sd.select(sql);
		List<BoardDto> boardList = new ArrayList<BoardDto>();
		try {
			while(rs.next()){
				//가져온 DB 값들 BoardDto 객체 생성 후 저장
				BoardDto bd = new BoardDto();
				bd.setBoard_id(rs.getInt(1));
				bd.setTitle(rs.getString(2));
				bd.setWriter(rs.getString(3));
				bd.setRead_cnt(rs.getInt(4));
				bd.setWdate(rs.getString(5));
				bd.setCont_like(rs.getInt(6));				
				boardList.add(bd);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			sd.closeDB();
		}		
		return boardList;
	}

	public BoardDto getContents(String b_id) {
		
		SetupDB sb = new SetupDB();
		String sql = "SELECT board_id, title, contents, writer, read_cnt, TO_CHAR(wdate, 'YYYY-MM-DD HH:MI:SS'), pds_link, cont_like, cont_unlike, password FROM kitri_board WHERE use_yn='Y' AND board_id ="+b_id;
		ResultSet rs;
		rs = sb.select(sql);
		
		BoardDto bDto = new BoardDto();
		
		try {
			if(rs.next()){
				bDto.setBoard_id(rs.getInt(1));
				bDto.setTitle(rs.getString(2));
				bDto.setContents(rs.getString(3));
				bDto.setWriter(rs.getString(4));
				bDto.setRead_cnt(rs.getInt(5));
				bDto.setWdate(rs.getString(6));
				bDto.setPds_link(rs.getString(7));
				bDto.setCont_like(rs.getInt(8));
				bDto.setCont_unlike(rs.getInt(9));
				bDto.setPassword(rs.getString(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			sb.closeDB();
		}		
		return bDto;
	}

	public int writeContents(BoardDto bDto) {
		// Insert문을 통해 bDto값 Database에 작성
		String sql = "INSERT INTO KITRI_BOARD (BOARD_ID, TITLE, CONTENTS, WRITER, PASSWORD, WDATE, PDS_LINK, REPLY_LEVEL) VALUES (SEQ_KITRI_BOARD.NEXTVAL, ?,?,?,?,SYSDATE,?,0)";
		SetupDB sdb = new SetupDB();
		PreparedStatement pstmt = null;
		int chk = 0;
		try {
			pstmt = sdb.getCon().prepareStatement(sql);
			pstmt.setString(1, bDto.getTitle());
			pstmt.setString(2, bDto.getContents());
			pstmt.setString(3, bDto.getWriter());
			pstmt.setString(4, bDto.getPassword());
			pstmt.setString(5, bDto.getPds_link());			
			chk = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			sdb.closeDB();
			
		}
		return chk;
	}

	public int modifyContents(BoardDto bDto) {
		String sql = "UPDATE KITRI_BOARD SET TITLE =?, CONTENTS=?, WRITER=?, PASSWORD=?, PDS_LINK=? WHERE BOARD_ID =?";
		SetupDB sdb = new SetupDB();
		PreparedStatement pstmt = null;
		int chk = 0;
		try {
			pstmt = sdb.getCon().prepareStatement(sql);
			pstmt.setString(1, bDto.getTitle());
			pstmt.setString(2, bDto.getContents());
			pstmt.setString(3, bDto.getWriter());
			pstmt.setString(4, bDto.getPassword());
			pstmt.setString(5, bDto.getPds_link());
			pstmt.setInt(6, bDto.getBoard_id());
			chk = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			sdb.closeDB();
			
		}
		return chk;
	}

	public int deleteContents(BoardDto bDto) {
		String sql = "UPDATE KITRI_BOARD SET use_yn='N'   WHERE board_id=? AND password = ? ";
		SetupDB sdb = new SetupDB();
		PreparedStatement pstmt = null;
		int chk = 0;
		try {
			pstmt = sdb.getCon().prepareStatement(sql);
			pstmt.setInt(1, bDto.getBoard_id());
			pstmt.setString(2, bDto.getPassword());
			chk = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			sdb.closeDB();			
		}
		return chk;
	}
}
