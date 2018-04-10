package hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HiveTest3 {

	public static void main(String[] args) throws Exception {

		Class.forName("org.apache.hive.jdbc.HiveDriver");
		Connection conn = DriverManager.getConnection("jdbc:hive2://192.168.111.102:10000/default", "root", "111111");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select year, month, count(*) as arrive_delay_count from airline_delay where ArrDelay>0 "
				+ "group by year, month;");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getInt(2)+ " " + rs.getInt(3));
		}
		conn.close();
		System.out.println("Success..!");
	}

}
