package oracleDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		//oracle사이트의 스키마로 들온거임
		String dbid ="db";
		String dbpwd = "111111";
		String url = "jdbc:oracle:thin:@192.168.111.100:1521:xe";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, dbid, dbpwd);
			System.out.println("Connection OK");
			
			pstmt = conn.prepareStatement("select * from customer");
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				System.out.println(rset.getString("ID") +" "+rset.getString("NAME"));
			}
			pstmt.close();
			rset.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
