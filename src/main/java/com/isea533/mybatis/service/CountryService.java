package com.isea533.mybatis.service;

import com.isea533.mybatis.model.Country;
import com.isea533.mybatis.model.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liuzh_3nofxnp
 * @since 2015-09-19 17:17
 */
public interface CountryService extends IService<Country> {

    /**
     * 根据条件分页查询
     *
     * @param country
     * @param page
     * @param rows
     * @return
     */
    List<Country> selectByCountry(Country country, int page, int rows);

    List selectCountryByParam(@Param("pojo") Country pojo,
                           @Param("orderObj") Order order, int page, int rows);

}
