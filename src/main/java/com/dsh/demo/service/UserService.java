package com.dsh.demo.service;

import java.util.List;

import com.dsh.demo.pojo.UserPo;

public interface UserService {
	
	List<UserPo> getAll();

	int insertUser(UserPo user);
}
