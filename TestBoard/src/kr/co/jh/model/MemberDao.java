package kr.co.jh.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {
	private SetupDB sd = new SetupDB();
	private ResultSet rs = null;
	
	public boolean chkUser(String b_id, String b_pass) {
		sd = new SetupDB();
		System.out.println("1");
		int chk = 0;
		String sql = "select * from KITRI_BOARD WHERE board_id='"+b_id+"' and password = '"+b_pass+"'";
		System.out.println("2");
		rs = sd.select(sql);
		
		try{
			if(rs.next()){
				chk = rs.getInt(1);
				System.out.println("chk = " + chk);
				if(chk != 0){
					System.out.println("3");
					return true;
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			sd.closeDB();
		}

		return false;
	}
}