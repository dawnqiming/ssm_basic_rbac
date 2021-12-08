package com.basic.rbac.service;

import com.basic.rbac.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author T480
 * @Version
 * @Date 2021/11/16
 */

public interface UserService {
    /**
     * @Description 查询用户登陆信息
     * @Date 2021/11/30 0:54
     * @Param [user]
     * @return com.basic.rbac.entity.User
     **/
    User queryLoginUser(User user);

    List<User> pageQueryData(Map<String, Object> map);

    int pageQueryCount(Map<String, Object> map);

    void insertUser(User user);

    User queryById(Integer id);

    void updateUser(User user);

    void deleteUserById(Integer id);

    void deleteUsers(Map<String, Object> map);

    void deleteUserRoles(Map<String, Object> map);

    void insertUserRoles(Map<String, Object> map);

    List<Integer> queryRoleidsByUserid(Integer id);
}
