package com.dsh.demo.service;

import com.dsh.demo.pojo.SysUserPo;

public interface SysUserService {


    SysUserPo getById(Integer id);

    SysUserPo findByUserName(String username);

}
