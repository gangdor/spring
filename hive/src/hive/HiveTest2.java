package hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HiveTest2 {

	public static void main(String[] args) throws Exception {

		Class.forName("org.apache.hive.jdbc.HiveDriver");
		Connection conn = DriverManager.getConnection("jdbc:hive2://192.168.111.200:10000/default", "root", "111111");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select detail_sec, seoul from criminal;");
		while (rs.next()) {
			System.out.println(rs.getString(1) + " " + rs.getInt(2)

			);
		}
		conn.close();
		System.out.println("Success..!");
	}

}
