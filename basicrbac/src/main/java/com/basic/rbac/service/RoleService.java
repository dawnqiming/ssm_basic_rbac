package com.basic.rbac.service;

import com.basic.rbac.entity.Role;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author T480
 * @Version
 * @Date 2021/11/16
 */
public interface RoleService {

    List<Role> pageQueryData(Map<String, Object> map);

    int pageQueryCount(Map<String, Object> map);

    List<Role> queryAll();

    void insertRolePermission(Map<String, Object> paramMap);

}
