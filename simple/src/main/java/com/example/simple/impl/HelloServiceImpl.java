package com.example.simple.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simple.bean.Person;
import com.example.simple.bean.Resp;
import com.example.simple.dao.HelloMapper;
import com.example.simple.service.HelloService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class HelloServiceImpl implements HelloService{
	@Autowired
	HelloMapper helloMapper;

	@Override
	public Resp getPersonList() {
		Resp resp = new Resp();
		try {
		PageHelper.startPage(0, 3);
		     
			List<Person> personList =helloMapper.getPersonList();
			PageInfo<Person> pageInfo = new PageInfo<Person>(personList);
			System.out.println(personList);
			resp.setCode("200");
			resp.setMsg("success");
			resp.setData(pageInfo);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("500");
			resp.setMsg("服务器凉了");
		}
		return resp;
		
	}

}
