package com.dsh.demo.service;

import com.dsh.demo.pojo.SysUserPo;

public interface SysUserService {

    SysUserPo findByUserName(String username);
}
