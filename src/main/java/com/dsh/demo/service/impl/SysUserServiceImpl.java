package com.dsh.demo.service.impl;


import com.dsh.demo.mapper.SysUserMapper;
import com.dsh.demo.pojo.SysUserPo;
import com.dsh.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUserPo findByUserName(String username) {
        SysUserPo use = sysUserMapper.findByUserName(username);
        return use;
    }
}
