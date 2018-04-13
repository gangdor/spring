package com.hw.controller;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hw.frame.Biz;
import com.hw.vo.Pop;

@Controller
public class MainController {
	Connection conn;

	/*public MainController() throws SQLException {
		try {
			Class.forName("org.apache.hive.jdbc.HiveDriver");
			conn = DriverManager.getConnection("jdbc:hive2://192.168.111.100:10000/default", "root", "111111");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

	@RequestMapping("/main.do")
	public String main() {
		return "main";
	}

	@RequestMapping("/chart1.do")
	public String chart1(Model m) {
		m.addAttribute("center", "chart1");
		return "main";
	}

	@RequestMapping("/chart2.do")
	public String chart2(Model m) {
		m.addAttribute("center", "chart2");
		return "main";
	}

	@RequestMapping("/chart3.do")
	public String chart3(Model m) {
		m.addAttribute("center", "chart3");
		return "main";
	}

	@RequestMapping("/chart4.do")
	public String chart4(Model m) {
		m.addAttribute("center", "chart4");
		return "main";
	}

	// hive에서 데려옴
	@RequestMapping("/chart1impl.do")
	@ResponseBody
	public void chart1impl(HttpServletResponse res) throws Exception {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select year, month, avg(arrdelay), avg(depdelay) from airline_delay where"
				+ " delayYear=2006 and arrdelay>0 group by year, month order by year, month");
		JSONArray ja = new JSONArray();

		while (rs.next()) {
			JSONArray data = new JSONArray();
			data.add(rs.getInt(2) + "월");
			data.add(rs.getInt(3));
			ja.add(data);
		}

		res.setCharacterEncoding("EUC-KR");
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		out.print(ja.toJSONString());
		out.close();
	}

	// hive에서 데려옴, criminal table 지움 2018.03.21
	@RequestMapping("/chart2impl.do")
	@ResponseBody
	public void chart2impl(HttpServletResponse res) throws Exception {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(
				"select column_name, seoul, pusan, daegu, incheon, gwangju, daejeon, ulsan, saejong from criminal where large_sec='강력범죄'");
		JSONArray ja = new JSONArray();
		while (rs.next()) {
			JSONObject data = new JSONObject();
			data.put("name", rs.getString(1));
			data.put("y", rs.getInt(2));
			data.put("z", 55);
			ja.add(data);
		}

		res.setCharacterEncoding("EUC-KR");
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		out.print(ja.toJSONString());
		out.close();
	}

	// 3번차트해보자
	@RequestMapping("/chart3impl.do")
	@ResponseBody
	public void chart3impl(HttpServletResponse res) throws Exception {
		Statement stmt = conn.createStatement();
		String sql_order = "select round(a.totalseoul/b.seoul*100000,1), round(a.totalbusan/b.busan*100000,1),"
				+ "       round(a.totaldaegu/b.daegu*100000,1), round(a.totalincheon/b.incheon*100000,1),"
				+ "       round(a.totalgwangju/b.gwangju*100000,1), round(a.totaldaejeon/b.daejeon*100000,1),"
				+ "       round(a.totalulsan/b.ulsan*100000,1), round(a.totalsaejong/b.saejong*100000,1)"
				+ "from (select sum(seoul) totalseoul, sum(busan) totalbusan, sum(daegu) totaldaegu, sum(incheon) totalincheon, sum(gwangju) totalgwangju,"
				+ "      sum(daejeon) totaldaejeon, sum(ulsan) totalulsan, sum(saejong) totalsaejong, year "
				+ "      from criminal " + "      where year=2016 group by year) A " + "inner join population B "
				+ "on a.year=b.year";

		String[] city = { "서울", "부산", "대구", "인천", "광주", "대전", "울산", "세종" };
		ResultSet rs = stmt.executeQuery(sql_order);
		JSONArray ja = new JSONArray();

		while (rs.next()) {
			for (int i = 0; i < city.length; i++) {
				JSONObject data = new JSONObject();
				data.put("name", city[i]);
				data.put("drilldown", city[i]);
				data.put("y", rs.getInt(i + 1));
				ja.add(data);
			}
		}

		res.setCharacterEncoding("EUC-KR");
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		out.print(ja.toJSONString());
		System.out.println(ja.toJSONString());
		out.close();
	}

	@RequestMapping("/chart3impl2.do")
	@ResponseBody
	public void chart3impl2(HttpServletResponse res) throws Exception {
		Statement stmt = conn.createStatement();
		String sql_order = "select a.large, round(a.totalseoul/b.seoul*100000,1), round(a.totalbusan/b.busan*100000,1), "
				+ "       round(a.totaldaegu/b.daegu*100000,1), round(a.totalincheon/b.incheon*100000,1),"
				+ "       round(a.totalgwangju/b.gwangju*100000,1), round(a.totaldaejeon/b.daejeon*100000,1),"
				+ "       round(a.totalulsan/b.ulsan*100000,1), round(a.totalsaejong/b.saejong*100000,1)"
				+ "from (select large, sum(seoul) totalseoul, sum(busan) totalbusan, "
				+ "        sum(daegu) totaldaegu, sum(incheon) totalincheon, "
				+ "        sum(gwangju) totalgwangju, sum(daejeon) totaldaejeon, "
				+ "        sum(ulsan) totalulsan, sum(saejong) totalsaejong, year"
				+ "        from criminal where year=2016 group by large, year) " + "A inner join population B "
				+ "on a.year=b.year";

		String[] city = { "서울", "부산", "대구", "인천", "광주", "대전", "울산", "세종" };
		ResultSet rs = stmt.executeQuery(sql_order);
		JSONArray cities = new JSONArray();
		JSONObject cityObj;
		for (int cityIndex = 0; cityIndex < city.length; cityIndex++) {
			cityObj = new JSONObject();
			cityObj.put("name", city[cityIndex]);
			cityObj.put("id", city[cityIndex]);
			cities.add(cityObj);
		}
		JSONArray crimesCity = new JSONArray();
		JSONArray crimes = null;
		for (int cityIndex = 0; cityIndex < city.length; cityIndex++) {
			crimes = new JSONArray();
			crimesCity.add(crimes);
		}
		JSONArray crime = null;
		while (rs.next()) {
			for (int cityIndex = 0; cityIndex < city.length; cityIndex++) {
				crime = new JSONArray();
				crime.add(rs.getString(1));
				crime.add(rs.getInt(cityIndex + 2));

				crimes = (JSONArray) crimesCity.get(cityIndex);
				crimes.add(crime);
				cityObj = (JSONObject) cities.get(cityIndex);
				cityObj.put("data", crimes);
			}
		}
		res.setCharacterEncoding("EUC-KR");
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		out.print(cities.toJSONString());
		System.out.println(cities.toJSONString());
		out.close();
	}
}
