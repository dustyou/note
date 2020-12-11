package cn.itcast.service;

import cn.itcast.domain.Province;

import java.util.List;

public interface ProvinceService {
    List<Province> findAll();
    String findAllJson();
}
