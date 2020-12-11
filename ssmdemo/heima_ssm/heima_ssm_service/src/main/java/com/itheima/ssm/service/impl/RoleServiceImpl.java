package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IRoleDao;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements IRoleService {
    
    @Autowired
    IRoleDao roleDao;
    
    @Override
    public List<Role> findAll() throws Exception {
        List<Role> list = roleDao.findAll();
        System.out.println(list);
        return list;
    }
    
    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }
    
    @Override
    public Role findById(int roleId) {
        return roleDao.findById(roleId);
    }
    
    @Override
    public void delete(int roleId) {
        roleDao.deleteFromUser_RoleByRoleId(roleId);
        roleDao.deleteFromRole_PermissionByRoleId(roleId);
        roleDao.deleteRoleById(roleId);
    }
    
    @Override
    public List<Permission> findOtherPermissions(int roleId) throws Exception {
        return roleDao.findOtherPermissions(roleId);
    }
    
    @Override
    public void addPermissionToRole(int roleId, int[] permissionIds) {
        for (int permissionId:permissionIds
             ) {
            roleDao.addPermissionToRole(roleId, permissionId);
        }
    }
}
