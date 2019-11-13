package com.example.simple.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simple.bean.Person;
import com.example.simple.dao.HelloMapper;
import com.example.simple.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService{
	@Autowired
	HelloMapper helloMapper;

	@Override
	public String getPersonList() {
		List<Person> personList =helloMapper.getPersonList();
		System.out.println(personList);
		return personList.toString(); 
	}

}
