package kr.co.jhchoi.model;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.jhchoi.domain.EmpBean;

public class EmpDao {

	// Database 연결 몇 EmpTable 자료 가져오기
	public List<EmpBean> getEmpAll() {
		List<EmpBean> al = new ArrayList<EmpBean>();

		// Driver Load
		try {
			String className = "oracle.jdbc.driver.OracleDriver";
			Class.forName(className);
			// Connection 생성
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "hr", "hr");
			// SQL문 DB에 전달
			String sql = "SELECT employee_id, first_name, manager_id FROM employees";
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			// Result Set에 있는값.
			// Result Set 객체를 java에 사용하는 EmpBean 객체에 복사

			while (rs.next()) {
				EmpBean eb = new EmpBean();
				
				 eb.setEmpno(rs.getInt("employee_id"));
				 eb.setEname(rs.getString("first_name"));
				 eb.setMgr(rs.getInt("manager_id"));
				 
/*				int no = rs.getInt("employee_id");
				String name = rs.getString("first_name");
				int mgr = rs.getInt("manager_id");

				eb.setEmpno(no);
				eb.setEname(name);
				eb.setMgr(mgr);
*/
				 al.add(eb);				
			}
			rs.close();
			stmt.close();
			con.close();
			return al;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
