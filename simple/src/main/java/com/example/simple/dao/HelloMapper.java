package com.example.simple.dao;

import java.util.List;

import com.example.simple.bean.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface HelloMapper {
	
	@Select("select * from user")
	List<Person> getPersonList();

}
