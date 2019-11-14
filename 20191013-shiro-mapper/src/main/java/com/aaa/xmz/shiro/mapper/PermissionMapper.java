package com.aaa.xmz.shiro.mapper;



import com.aaa.xmz.shiro.model.Permission;

import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    Permission selectByPrimaryKey(Long id);

    List<Permission> selectAll();

    int updateByPrimaryKey(Permission record);

    List<String> selectPermissionByUsername(String username);
}