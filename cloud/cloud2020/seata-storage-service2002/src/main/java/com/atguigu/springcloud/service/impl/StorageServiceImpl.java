package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.StorageDao;
import com.atguigu.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    
    private final static Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);
    
    @Resource
    private StorageDao storageDao;
    
    @Override
    public void decrease(Long productId, Integer count) {
        LOGGER.info("---->storage-service中扣减库存开始");
        storageDao.decrease(productId, count);
        LOGGER.info("---->storage-service中扣减库存结束");
    }
}
