package com.dsh.demo.pojo;

import java.util.List;

public class SysUserPo {
    private Integer id;
    private String username;
    private String password;
    private String type;

    private List<SysRolePo> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<SysRolePo> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRolePo> roles) {
        this.roles = roles;
    }
}
