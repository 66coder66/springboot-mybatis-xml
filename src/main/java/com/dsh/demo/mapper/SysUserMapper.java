package com.dsh.demo.mapper;

import com.dsh.demo.pojo.SysUserPo;

import java.util.List;
import java.util.Map;

public interface SysUserMapper {


    List<SysUserPo> getByMap(Map<String, Object> map);
    List<SysUserPo> getByRoleId(Map<String, Object> map);
    SysUserPo getById(Integer id);
    Integer create(SysUserPo user);
    int update(SysUserPo user);
    SysUserPo getByUserName(String userName);
}
