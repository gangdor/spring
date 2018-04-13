package com.hw.controller;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	Connection conn;

	public MainController() throws SQLException {
		try {
			Class.forName("org.apache.hive.jdbc.HiveDriver");
			conn = DriverManager.getConnection("jdbc:hive2://192.168.111.101:10000/default", "root", "111111");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/main.do")
	public String main() {
		return "main";
	}
	@RequestMapping("/chart1.do")
	public String chart1(Model m) {
		m.addAttribute("center", "chart1");
		return "main";
	}
	// hive¿¡¼­ µ¥·Á¿È
	@RequestMapping("/chart1impl.do")
	@ResponseBody
	public void chart1impl(HttpServletResponse res) throws Exception {
		Statement stmt = conn.createStatement();
		String order = "select large, sumall from criminal where year=2016";
		ResultSet rs = stmt.executeQuery(order);
		JSONArray ja = new JSONArray();
		while (rs.next()) {
			JSONArray data = new JSONArray();
			data.add(rs.getString(1));
			data.add(rs.getInt(2));
			ja.add(data);
		}
		res.setCharacterEncoding("EUC-KR");
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		System.out.println(ja.toJSONString());
		out.print(ja.toJSONString());
		out.close();
	}
}
