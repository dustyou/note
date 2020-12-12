package com.atguigu.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface AccountDao {
    //2. 扣减账户余额
    void decrease(@Param("userId") Long userId, @Param("money")BigDecimal money);
}
