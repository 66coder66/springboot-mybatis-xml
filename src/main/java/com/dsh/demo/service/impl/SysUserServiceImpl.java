package com.dsh.demo.service.impl;


import com.dsh.demo.mapper.SysUserMapper;
import com.dsh.demo.pojo.SysUserPo;
import com.dsh.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Service;

@Service(value = "sysuserService")
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SessionRegistry sessionRegistry;


    public SysUserPo getById(Integer id) {
        SysUserPo user = sysUserMapper.getById(id);
        return user;
    }
    @Override
    public SysUserPo findByUserName(String username) {
        SysUserPo use = sysUserMapper.findByUserName(username);
        return use;

    }
}
