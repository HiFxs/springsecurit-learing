package com.yy.example.dao;


import com.yy.example.bean.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface UserDao {

	List<User> getByMap(Map<String, Object> map);
	List<User> getByRoleId(Map<String, Object> map);
	User getById(Integer id);
	Integer create(User user);
	int update(User user);
	User getByUserName(String userName);
}