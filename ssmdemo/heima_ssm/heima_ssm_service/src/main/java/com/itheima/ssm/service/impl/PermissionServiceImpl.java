package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IPermissionDao;
import com.itheima.ssm.dao.IProductDao;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.service.IPermissionService;
import com.itheima.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("permissionService")
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    IPermissionDao permissionDao;
    @Override
    public List<Permission> findAll() throws Exception {
        List<Permission> permissionList = permissionDao.findAll();
        return permissionList;
    }
    
    @Override
    public void save(Permission permission) throws Exception{
        permissionDao.save(permission);
    }
}
