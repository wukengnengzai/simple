package com.example.simple.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simple.bean.Person;
import com.example.simple.bean.Resp;
import com.example.simple.dao.HelloMapper;
import com.example.simple.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService{
	@Autowired
	HelloMapper helloMapper;

	@Override
	public Resp getPersonList() {
		Resp resp = new Resp();
		try {
			List<Person> personList =helloMapper.getPersonList();
			System.out.println(personList);
			resp.setCode("200");
			resp.setMsg("success");
			resp.setData(personList);
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("500");
			resp.setMsg("服务器凉了");
		}
		return resp;
		
	}

}
