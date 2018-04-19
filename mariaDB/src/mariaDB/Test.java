package mariaDB;

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
		
		String dbid ="user1";
		String dbpwd = "111111";
		String url = "jdbc:mysql://192.168.111.100:3306/shopping_db";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
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
