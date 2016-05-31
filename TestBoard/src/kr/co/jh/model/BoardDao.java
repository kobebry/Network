package kr.co.jh.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.jh.model.BoardDto;

public class BoardDao {

	public List<BoardDto> getList() {
		SetupDB sd = new SetupDB();
		String sql = "SELECT board_id, title, writer, read_cnt, TO_CHAR(wdate, 'YYYY-MM-DD HH:MI:SS'), cont_like FROM KITRI_BOARD WHERE use_yn = 'Y' ORDER BY BOARD_ID DESC";
		ResultSet rs = sd.select(sql);
		List<BoardDto> boardList = new ArrayList<BoardDto>();

		try {
			while (rs.next()) {
				// 가져온 DB 값들 BoardDto 객체 생성 후 저장
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
		} finally {
			sd.closeDB();
		}
		return boardList;
	}

	public BoardDto getContents(String b_id) {
		SetupDB sd = new SetupDB();
		String sql = "SELECT board_id, title, writer, read_cnt, TO_CHAR(wdate, 'YYYY-MM-DD HH:MI:SS'), pds_link, cont_like, cont_unlike, password FROM KITRI_BOARD WHERE use_yn='Y' AND board_id ="
				+ b_id;
		ResultSet rs = sd.select(sql);

		BoardDto bd = new BoardDto();

		try {
			while (rs.next()) {
				bd.setBoard_id(rs.getInt(1));
				bd.setTitle(rs.getString(2));
				bd.setWriter(rs.getString(3));
				bd.setRead_cnt(rs.getInt(4));
				bd.setWdate(rs.getString(5));
				bd.setPds_link(rs.getString(6));
				bd.setCont_like(rs.getInt(7));
				bd.setCont_unlike(rs.getInt(8));
				bd.setPassword(rs.getString(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			sd.closeDB();
		}
		return bd;
	}

	public BoardDto InsertMember(BoardDto bDto) {
		SetupDB sd = new SetupDB();
		String sql = "INSERT INTO kitri_board (TITLE, PDS_LINK) VALUES(?,?)";
		ResultSet rs =sd.select(sql);
		BoardDto bd = new BoardDto();
		
		try {
			while(rs.next()){
				bd.setTitle(rs.getString(1));
				bd.setPds_link(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			sd.closeDB();
		}
		return bd;
	}
}