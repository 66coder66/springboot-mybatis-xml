package com.dsh.demo.mapper;

import com.dsh.demo.pojo.SysUserPo;

public interface SysUserMapper {

    SysUserPo findByUserName(String username);
}
