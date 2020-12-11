package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import org.apache.ibatis.annotations.*;


import java.util.List;

public interface IRoleDao {
    
    @Select("select * from role")
    List<Role> findAll() throws Exception;
    
    //根据用户id查询出所有对应的角色
    @Select(("select * from role where id in (select roleId from users_role where userId=#{userId})"))
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class, many = @Many(select = "com.itheima.ssm.dao.IPermissionDao.findPermissionByRoleId")),
    })
    List<Role> findRoleByUserId(String userId) throws Exception;
    
    @Insert("insert into role (roleName, roleDesc) values(#{roleName}, #{roleDesc})")
    void save(Role role) throws Exception;
    
    @Select("select * from role where id = #{roleId}")
    
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class, many = @Many(select = "com.itheima.ssm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    Role findById(int roleId);
    

    @Delete(("delete from users_role where roleId = #{roleId}"))
    void deleteFromUser_RoleByRoleId(int roleId);
    
    @Delete(("delete from role_permission where roleId = #{roleId}"))
    void deleteFromRole_PermissionByRoleId(int roleId);
    
    @Delete(("delete from role where id = #{roleId}"))
    void deleteRoleById(int roleId);
    
    @Select("select * from permission where id not in (select permissionId from role_permission where roleId = #{roleId})")
    List<Permission> findOtherPermissions(int roleId) throws Exception;
    
    @Insert("insert into role_permission (roleId, permissionId) values (#{roleId}, #{permissionId})")
    void addPermissionToRole(@Param("roleId") int roleId, @Param("permissionId") int permissionId);
}
