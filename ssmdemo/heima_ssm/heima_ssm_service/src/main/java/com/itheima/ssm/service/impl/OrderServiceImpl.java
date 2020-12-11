package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.IOrderDao;
import com.itheima.ssm.domain.Order;
import com.itheima.ssm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderDao orderDao;
    
    @Override
    public List<Order> findAll(int page, int size) throws Exception {
        //参数pageNum是页码值, 参数pageSize代表每页显示条数
        //在分页查询前加上这一句, 下面跟查询语句, 中间不能有其它代码
        PageHelper.startPage(page, size);
        return orderDao.findAll();
    }
    
    @Override
    public Order findById(int orderId) throws Exception {
        
        return orderDao.findById(orderId);
    }
}
