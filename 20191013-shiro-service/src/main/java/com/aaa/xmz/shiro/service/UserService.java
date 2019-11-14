package com.aaa.xmz.shiro.service;

import com.aaa.xmz.shiro.mapper.PermissionMapper;
import com.aaa.xmz.shiro.mapper.RoleMapper;
import com.aaa.xmz.shiro.mapper.UserMapper;
import com.aaa.xmz.shiro.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Company AAA软件教育
 * @Author Seven xmz
 * @Date Create in 2019/10/12 9:51
 * @Description
 **/
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * @author Seven xmz
     * @description
     *      通过用户名查询用户信息
     *      规定:
     *          所有和业务逻辑有关的代码全部写在service层，controller不能出现任何一行，controller只负责跳转，不负责处理业务逻辑
     *          以后的所有controller返回和service返回都必须要统一
     * @param [username]
     * @date 2019/10/12
     * @return com.aaa.xmz.shiro.model.User
     * @throws 
    **/
    public Map<String, Object> selectUserByUsername(String username) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        User user = userMapper.selectUserByUsername(username);
        // null:防止空指针异常
        // 使用包装类型也可以防止空指针异常(Integer == 1)
        if(null == user) {
            // 数据库中没有数据
            resultMap.put("code", "400");
            resultMap.put("msg", "用户不存在");
        } else {
            resultMap.put("code", "200");
            resultMap.put("data", user);
        }
        return resultMap;
    }

    /**
     * @author Seven xmz
     * @description
     *      通过用户名查询所有的角色名称
     * @param [username]
     * @date 2019/10/12
     * @return Map
     * @throws 
    **/
    public Map<String, Object> selectRoleByUsername(String username) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<String> roleList = roleMapper.selectRoleByUsername(username);
        if(roleList.size() > 0) {
            // 说明该登录用户有角色
            resultMap.put("code", "200");
            resultMap.put("data", roleList);
        } else {
            resultMap.put("code", "404");
            resultMap.put("msg", "当前登录用户没有角色");
        }
        return resultMap;
    }

    /**
     * @author Seven xmz
     * @description
     *      通过用户名查询所有的权限名称
     * @param [username]
     * @date 2019/10/12
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @throws 
    **/
    public Map<String, Object> selectPermissionByUsername(String username) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<String> permissionList = permissionMapper.selectPermissionByUsername(username);
        if(permissionList.size() > 0) {
            // 说明该用户的角色拥有权限
            resultMap.put("code", "200");
            resultMap.put("data", permissionList);
        } else {
            resultMap.put("code", "404");
            resultMap.put("msg", "当前登录用户所拥有角色没有权限");
        }
        return resultMap;
    }


}
