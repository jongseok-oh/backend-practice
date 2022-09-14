import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

public class DeptDAO {
	
	static final String DRIVER_CLASSNAME = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC";
	static final String DB_USER = "ssafy";
	static final String DB_PASS = "ssafy";
	
	static {
		try {
			Class.forName(DRIVER_CLASSNAME);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public int insertDept(Dept dept) {
		Connection conn =  null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into dept(deptno, dname, loc) values(?,?,?)";
		// step2
		try {
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
			
			// step 3
			pstmt = conn.prepareStatement(sql);
			
			// step 4
			pstmt.setInt(1, dept.getDeptNo());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());
			int rowCnt = pstmt.executeUpdate();
			
			System.out.println(rowCnt + " 행이 처리되었습니다.");
			
			return rowCnt;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return 0;
	}
	
	public List<Dept> selectDepts() {
		Connection conn =  null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<Dept> list = new ArrayList<>();
		String sql = "select deptno, dname, loc from dept";
		// step2
		try {
			conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
			
			// step 3
			pstmt = conn.prepareStatement(sql);
			
			// step 4
			rs = pstmt.executeQuery();
			
			// step 5
			
			while(rs.next())
            {
                list.add(new Dept(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return list;
	}
}
