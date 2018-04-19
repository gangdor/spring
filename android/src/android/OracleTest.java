package android;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class OracleTest {

	public static void main(String[] args) throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@70.12.114.144:1521:XE","cracking","111111");
		Statement stmt = conn.createStatement();
		String sql = "insert into INFO values('1','±è°æ¹Î','123','1',sysdate,null)";
		stmt.executeUpdate(sql);
	}

}
