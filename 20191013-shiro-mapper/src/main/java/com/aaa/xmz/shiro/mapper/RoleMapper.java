package com.aaa.xmz.shiro.mapper;

import com.aaa.xmz.shiro.model.Role;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    Role selectByPrimaryKey(Long id);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);

    List<String> selectRoleByUsername(String username);
}