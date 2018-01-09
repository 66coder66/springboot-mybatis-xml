package com.dsh.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsh.demo.mapper.UserMapper;
import com.dsh.demo.pojo.UserPo;
import com.dsh.demo.service.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Autowired
    private UserMapper userMapper;
	
	@Override
	public List<UserPo> getAll() {
		
		return userMapper.getAll();
	}
	
	
	@Override
	public int insertUser(UserPo user) {
		
		return userMapper.insert(user);
	}

}
