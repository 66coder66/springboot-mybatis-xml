package com.dsh.demo.mapper;

import com.dsh.demo.pojo.PermissionPo;

import java.util.List;
import java.util.Map;

public interface PermissionMapper {


    List<PermissionPo> getByMap(Map<String, Object> map);

    PermissionPo getById(Integer id);

    Integer create(PermissionPo permission);

    int update(PermissionPo permission);

    List<PermissionPo> getByUserId(Integer userId);
}
