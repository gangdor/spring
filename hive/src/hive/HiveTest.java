package hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HiveTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("org.apache.hive.jdbc.HiveDriver");
		Connection conn = DriverManager.getConnection
				("jdbc:hive2://192.168.111.101:10000/default", "root", "111111");
		Statement stmt = conn.createStatement();
		String order_hive="select * from criminal";
		ResultSet rs = stmt.executeQuery(order_hive);
		while (rs.next()) {
			System.out.println(rs.getString(1) + " " + rs.getString(2) + " "
					+ rs.getInt(3) + " "+ rs.getInt(4) + " "+ rs.getInt(5) + " "
					+ rs.getInt(6) + " "+ rs.getInt(7) + " "+ rs.getInt(8) + " "
					+ rs.getInt(9) + " "+ rs.getInt(10) + " "+ rs.getInt(11)
			);
		}
		conn.close();
		System.out.println("Success..!");
	}
}