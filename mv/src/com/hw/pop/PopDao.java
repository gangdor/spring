package com.hw.pop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hw.frame.Dao;
import com.hw.mapper.PopMapper;
import com.hw.vo.Pop;
import com.hw.vo.Product;
@Repository("popDao")
public class PopDao implements Dao<Pop, String> {

	@Autowired
	PopMapper mapper;
	
	
	@Override
	public Pop select(String s) {
		return mapper.select(s);
	}

	@Override
	public List<Pop> select() {
		return mapper.selectall();
	}

	@Override
	public void insert(Pop t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Pop t) {
		// TODO Auto-generated method stub
		
	}

	
}
