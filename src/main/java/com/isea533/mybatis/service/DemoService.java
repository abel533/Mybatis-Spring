package com.isea533.mybatis.service;

import com.isea533.mybatis.mapper.CountryMapper;
import com.isea533.mybatis.model.Country;
import com.isea533.mybatis.model.Country2;
import com.isea533.mybatis.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author liuzh
 */
@Service
public class DemoService extends BaseService<Country2> {
    @Autowired
    private CountryMapper countryMapper;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Country selectById(int id) {
        return countryMapper.selectByPrimaryKey(id);
    }

    public Country selectById2(int id) {
        Country country = jdbcTemplate.queryForObject("select * from country where id = :id", new BeanPropertyRowMapper<Country>(Country.class), id);
        return country;
    }

    public List<Country> selectPage(int pageNum,int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return countryMapper.select(null);
    }

    public List<Country2> selectPage2(int pageNum,int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        //Spring4支持泛型注入
        return mapper.select(null);
    }
}
