package com.isea533.mybatis.service;

import com.isea533.mybatis.model.Country2;
import org.springframework.stereotype.Service;

/**
 * @author liuzh
 */
@Service
public class DemoService extends BaseService<Country2>{

    public int save(Country2 country2) {
        if (country2 == null) {
            throw new NullPointerException("保存的对象不能为空!");
        }
        if (country2.getCountrycode() == null || country2.getCountrycode().equals("")) {
            throw new RuntimeException("国家代码不能为空!");
        }
        if (country2.getCountryname() == null || country2.getCountryname().equals("")) {
            throw new RuntimeException("国家名称不能为空!");
        }
        return super.save(country2);
    }

}
