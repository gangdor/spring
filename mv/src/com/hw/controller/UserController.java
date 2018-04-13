package com.hw.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hw.frame.Biz;
import com.hw.vo.User;

@Controller
public class UserController {
		
	@Resource(name="userBiz")
	Biz<User,String> biz;
	
	@RequestMapping("/userlist.do")
	public String list(Model m) {
		// Database에서 데이터를 가지고 온다.
		List<User> list = null;
		list = biz.get();
		m.addAttribute("userlist", list);
		m.addAttribute("center", "user/list");
		return "main";
	}
	@RequestMapping("/useradd.do")
	public String add(Model m) {
		m.addAttribute("center", "user/add");
		return "main";
	}
	@RequestMapping("/useraddimpl.do")
	public String addimpl(Model m,User u) {
		System.out.println("addimpl:"+m);
		// DB에 입력 한다.
		biz.register(u);
		m.addAttribute("center", "user/addok");
		return "main";
	}
	
	@RequestMapping("/userdetail.do")
	public String detail(Model m, @RequestParam(value="id")String userid) {
		System.out.println(userid);
		User user = biz.get(userid);
		m.addAttribute("userselect", user);
		m.addAttribute("center", "user/detail");
		return "main";
	}
	
	@RequestMapping("/userupdate.do")
	public String update(Model m, User u) {
		biz.modify(u);
		m.addAttribute("center", "user/modifyok");
		return "main";
	}
	
	@RequestMapping("/userdelete.do")
	public String delete(Model m, @RequestParam(value="id")String userid) {
		biz.remove(userid);
		m.addAttribute("center", "user/deleteok");
		return "main";
	}
	
}



