package com.hw.pop;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hw.frame.Biz;
import com.hw.frame.Dao;
import com.hw.vo.Pop;
@Service("popBiz")
public class PopBiz implements Biz<Pop, String> {

	@Resource(name="popDao")
	Dao<Pop, String> dao;
	
	public PopBiz() {
		dao = new PopDao();
	}
	
	
	@Override
	public Pop get(String s) {
		return dao.select(s);
	}

	@Override
	public List<Pop> get() {
		return dao.select();
	}


	@Override
	public void register(Pop t) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void remove(String s) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void modify(Pop t) {
		// TODO Auto-generated method stub
		
	}

}
