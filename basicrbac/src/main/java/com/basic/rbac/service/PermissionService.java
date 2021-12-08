package com.basic.rbac.service;

import com.basic.rbac.entity.Permission;
import com.basic.rbac.entity.User;

import java.util.List;

/**
 * @Description
 * @Author T480
 * @Version V1.0.0
 * @Date 2021/11/16
 */
public interface PermissionService {

    Permission queryRootPermission();

    List<Permission> queryChildPermissions(Integer pid);

    List<Permission> queryAll();

    void insertPermission(Permission permission);

    Permission queryById(Integer id);

    void updatePermission(Permission permission);

    void deletePermission(Permission permission);

    List<Integer> queryPermissionidsByRoleid(Integer roleid);

    List<Permission> queryPermissionsByUser(User dbUser);
}
