package com.basic.rbac.dao;

import com.basic.rbac.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author T480
 * @Version
 * @Date 2021/11/12
 */
@Mapper
public interface RoleDao {

    List<Role> pageQueryData(Map<String, Object> map);

    int pageQueryCount(Map<String, Object> map);

    @Select("select * from t_role")
    List<Role> queryAll();

    void insertRolePermission(Map<String, Object> paramMap);

    void deleteRolePermissions(Map<String, Object> paramMap);

}
