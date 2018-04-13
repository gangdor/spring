package oracletest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class oraclett {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.111.101:1521:xe", "criminal", "111111");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select detail, seoul from criminal");
		while (rs.next()) {
			System.out.println(rs.getString(1) + " " + rs.getInt(2));
		}
		conn.close();
		System.out.println("Success..!");
	}
}
