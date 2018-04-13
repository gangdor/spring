package com.hw.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hw.frame.Biz;
import com.hw.vo.Product;

@Controller
public class ProductController {
		
	@Resource(name="productBiz")
	Biz<Product,Integer> biz;
	
	@RequestMapping("/productlist.do")
	public String list(Model m) {
		// DB에서 데이터를 조회 한다.
		List<Product> list = null;
		list = biz.get();
		m.addAttribute("productlist", list);
		m.addAttribute("center", "product/list");
		return "main";
	}
	@RequestMapping("/productadd.do")
	public String add(Model m) {
		m.addAttribute("center", "product/add");
		return "main";
	}
	@RequestMapping("/productaddimpl.do")
	public String addimpl(Model m,Product p) {
		System.out.println(p);
		MultipartFile mf = p.getMf();
		String imgName = mf.getOriginalFilename();
		System.out.println(imgName);
		p.setImgname(imgName);
		byte[] data = null;
		FileOutputStream fo = null;
		try {
			data = mf.getBytes();
			fo = 
			new FileOutputStream("C:\\spring\\mv\\web\\img\\"+imgName);
			fo.write(data);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				fo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// DB에 입력
		biz.register(p);
		m.addAttribute("imgname",imgName);
		m.addAttribute("center", "product/addok");
		return "main";
	}
	@RequestMapping("/productdetail.do")
	public String detail(Model m, @RequestParam(value="id")int productid) {
		System.out.println(productid);
		Product product = biz.get(productid);
		m.addAttribute("productselect", product);
		m.addAttribute("center", "product/detail");
		return "main";
	}
	
	@RequestMapping("/productupdate.do")
	public String update(Model m, Product p) {
		System.out.println(p);
		System.out.println("이름 체크크크ㅡ" + p.getImgname());
		if(!p.getMf().isEmpty()) {
			MultipartFile mf = p.getMf();
			String imgName = mf.getOriginalFilename();
			p.setImgname(imgName);
			byte[] data = null;
			FileOutputStream fo = null;
			try {
				data = mf.getBytes();
				fo = 
				new FileOutputStream("C:\\spring\\mv\\web\\img\\"+imgName);
				fo.write(data);
			} catch (IOException e) {
				e.printStackTrace();
			} finally{
				try {
					fo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		else {
		}
		biz.modify(p);
		m.addAttribute("center", "product/modifyok");
		return "main";
	}
	@RequestMapping("/productdelete.do")
	public String delete(Model m, @RequestParam(value="id")int productid) {
		biz.remove(productid);
		m.addAttribute("center", "product/deleteok");
		return "main";
	}
}




