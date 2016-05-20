package kr.co.jhchoi.model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpDao {
	//Emp자료 접근용 Data Access Object
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	
	//DB ID 값 비교하여 접근하기	
	public int chk_id(String empno, String ename){
		String sql ="SELECT count(*) FROM employees WHERE employee_id ="+empno+" AND first_name ='"+ename+"'";
		System.out.println(sql);
		rs = select(sql);
		int login_chk=0;		
		try {
			if(rs.next()){
				//로그인체크 0,1이상의 숫자
				login_chk = rs.getInt(1); //첫번째 값
				//1이면 로그인 완료
				//0이면 로그인 실패
			}
			closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return login_chk;
	}
	
	//Connection 생성 메소드
	private Connection getCon(){
		try {
			Class.forName("core.log.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "hr", "hr");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	// Statement 생성 1.RS => RS, 2.RS(X) => int
	private ResultSet select(String sql){
		try {
			stmt = getCon().createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return rs;
	}
	
	private void closeDB(){
		//con, stmt, rs
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}

	public EmpDto getEmp(String empno) {
		String sql = "SELECT employee_id, first_name, last_name, email, phone_number, TO_CHAR(hire_date, 'YYYY-MM-DD'), job_id, salary, commission_pct*100, manager_id FROM employees WHERE employee_id = ?";
		EmpDto ed = new EmpDto();
		try {
			pstmt = getCon().prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(empno));
			rs = pstmt.executeQuery();
			if(rs.next()){
				ed.setEmployee_id(rs.getInt(1));
				ed.setFirst_name(rs.getString(2));
				ed.setLast_name(rs.getString(3));
				ed.setEmail(rs.getString(4));
				ed.setPhone_number(rs.getString(5));
				ed.setHire_date(rs.getString(6));
				ed.setJob_id(rs.getString(7));
				ed.setSalary(rs.getInt(8));
				ed.setCommission_pct(rs.getInt(9));
				ed.setManager_id(rs.getInt(10));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}		
		closeDB();
		
		return ed;		
	}

	public int modEmp(EmpDto ed) {
		//PrepareStatement Update문 실행
		String sql = "UPDATE employees SET first_name = ?, last_name = ?, phone_number = ?, email = ?, hire_date = TO_DATE(?,'YYYY-MM-DD'), job_id=?, salary=?, commission_pct=?, manager_id=? WHERE employee_id=?";
		int cnt = 0;
		try {
			pstmt = getCon().prepareStatement(sql);
			pstmt.setString(1, ed.getFirst_name());
			pstmt.setString(2, ed.getLast_name());
			pstmt.setString(3, ed.getPhone_number());
			pstmt.setString(4, ed.getEmail());
			pstmt.setString(5, ed.getHire_date());
			pstmt.setString(6, ed.getJob_id());
			pstmt.setInt(7, ed.getSalary());
			pstmt.setDouble(8, (double)ed.getCommission_pct()/100);
			pstmt.setInt(9, ed.getManager_id());
			pstmt.setInt(10, ed.getEmployee_id());
			cnt = pstmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			closeDB();
		return cnt;
	}
}
