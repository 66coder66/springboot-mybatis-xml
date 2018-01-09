package com.dsh.demo.mapper;

import java.util.List;
//import org.apache.ibatis.annotations.Select;
import com.dsh.demo.pojo.UserPo;


public interface UserMapper {
	
	//@Select("SELECT * FROM tb_user")
    List<UserPo> getAll();

	UserPo getOneUser(Long id);

	int insert(UserPo user);

	int update(UserPo user);
	
	int delete(Long id);
}
