package com.aaa.xmz.shiro.mapper;

import com.aaa.xmz.shiro.model.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    User selectByPrimaryKey(Long id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User selectUserByUsername(String username);
}