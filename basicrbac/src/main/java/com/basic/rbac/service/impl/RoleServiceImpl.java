package com.basic.rbac.service.impl;

import com.basic.rbac.dao.RoleDao;
import com.basic.rbac.entity.Role;
import com.basic.rbac.service.RoleService;
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
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> pageQueryData(Map<String, Object> map) {
        return roleDao.pageQueryData(map);
    }

    @Override
    public int pageQueryCount(Map<String, Object> map) {
        return roleDao.pageQueryCount(map);
    }

    @Override
    public List<Role> queryAll() {
        return roleDao.queryAll();
    }

    @Override
    public void insertRolePermission(Map<String, Object> paramMap) {
        roleDao.deleteRolePermissions(paramMap);
        roleDao.insertRolePermission(paramMap);
    }
}
