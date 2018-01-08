package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dsh.demo.mapper.UserMapper;
import com.dsh.demo.pojo.UserPo;


/**
 * 官方建议 ：自定义的controller位置与启动类application.java 的位置要同级
 * @author dsh
 *
 */
@Controller
public class MyController{
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/home")
    @ResponseBody
    public String home() {
        return "Hello World!";
    }
	/**
	 * 根据id查询用户
	 * @param id
	 * @return
	 */
	@RequestMapping("/getOneUser/{id}")
	@ResponseBody
    public String getOneUser(@PathVariable("id") Long id) {
		String res = "";
		UserPo user = userMapper.getOneUser(id);
		if(null != user){
			res = user.toString();
		}
        return res;
    }
	/**
	 * 获取用户列表
	 * @return
	 */
	@RequestMapping("/getUsers")
	public @ResponseBody String getUsers() {
		List<UserPo> users = userMapper.getAll();
		return users.toString();
	}
	@RequestMapping("/add")
    public @ResponseBody int save(UserPo user) {
		int i = userMapper.insert(user);
    	 return i;
    }
    
    @RequestMapping(value="/update")
    public @ResponseBody int update(UserPo user) {
    	int i = userMapper.update(user);
    	return i;
    }
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/delete/{id}")
    public @ResponseBody int delete(@PathVariable("id") Long id) {
    	int i = userMapper.delete(id);
    	return i;
    }
}