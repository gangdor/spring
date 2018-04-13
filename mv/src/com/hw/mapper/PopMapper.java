package com.hw.mapper;

import java.util.List;

import com.hw.vo.Pop;

public interface PopMapper {
	public Pop select(String id);
	public List<Pop> selectall();
}
