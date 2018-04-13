package com.hw.controller;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
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
public class PopController {
	Connection conn;

	@Resource(name="popBiz")
	Biz<Pop,String> biz;
	
	//oracle에서 불러옴, 됌
	@RequestMapping("/poplist.do")
	@ResponseBody
	public void list(HttpServletResponse res) throws Exception{
		// Database에서 데이터를 가지고 온다.
		List<Pop> list = null;
		list = biz.get();
		JSONArray ja = new JSONArray();
		 for(Pop d:list ) {
	         JSONObject data = new JSONObject();
	         data.put("name",d.getDong());
	         data.put("y", d.getOne());
	         data.put("Z", 55);
	         ja.add(data);
	      }
		res.setCharacterEncoding("EUC-KR");
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		out.print(ja.toJSONString());
		out.close();
	}
	
	@RequestMapping("/popdetail.do")
	public String detail(Model m, String popid) {
		System.out.println(popid);
		Pop pop = biz.get(popid);
		m.addAttribute("popselect", pop);
		m.addAttribute("center", "pop/detail");
		return "main";
	}
	
	
	
	/*
	@RequestMapping("/popadd.do")
	public String add(Model m) {
		m.addAttribute("center", "pop/add");
		return "main";
	}
	@RequestMapping("/popaddimpl.do")
	public String addimpl(Model m,Pop u) {
		System.out.println("addimpl:"+m);
		// DB에 입력 한다.
		biz.register(u);
		m.addAttribute("center", "pop/addok");
		return "main";
	}
	
	@RequestMapping("/popupdate.do")
	public String update(Model m, pop u) {
		biz.modify(u);
		m.addAttribute("center", "pop/modifyok");
		return "main";
	}
	
	@RequestMapping("/popdelete.do")
	public String delete(Model m, @RequestParam(value="id")String popid) {
		biz.remove(popid);
		m.addAttribute("center", "pop/deleteok");
		return "main";
	}*/
	
}



