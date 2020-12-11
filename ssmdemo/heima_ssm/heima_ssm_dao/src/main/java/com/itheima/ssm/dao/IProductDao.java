package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IProductDao {
    
    @Select("select * from product")
    List<Product> findAll() throws Exception;

    @Insert("INSERT INTO product(productNum, productName, cityName,  productPrice, productDesc, productStatus) VALUES (#{productNum}, #{productName}, #{cityName}, #{productPrice}, #{productDesc}, #{productStatus})")
//    @Insert("INSERT INTO product(productNum) VALUES (${productNum})")
    void save(Product product) throws Exception;
    
    @Select("select * from product where id = #{id}")
    public Product findById(int id) throws Exception;
}

