package com.basic.rbac.service.impl;

import com.basic.rbac.dao.UserDao;
import com.basic.rbac.entity.User;
import com.basic.rbac.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author T480
 * @Version
 * @Date 2021/11/16
 */
@Service
public class UsreServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public List<User> queryAll() {
        return userDao.queryAll();
    }

    @Override
    public User queryLoginUser (@Param("user") User user) {
        return userDao.queryLoginUser(user);
    }

    @Override
    public List<User> pageQueryData(Map<String, Object> map) {
        return userDao.pageQueryData(map);
    }

    @Override
    public int pageQueryCount(Map<String, Object> map) {
        return userDao.pageQueryCount(map);
    }

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public User queryById(Integer id) {
        return userDao.queryById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        userDao.deleteUserById(id);
    }

    @Override
    public void deleteUsers(Map<String, Object> map) {
        userDao.deleteUsers(map);
    }

    @Override
    public void deleteUserRoles(Map<String, Object> map) {
        userDao.deleteUserRoles(map);
    }

    @Override
    public void insertUserRoles(Map<String, Object> map) {
        userDao.insertUserRoles(map);
    }

    @Override
    public List<Integer> queryRoleidsByUserid(Integer id) {
        return userDao.queryRoleidsByUserid(id);
    }
}
