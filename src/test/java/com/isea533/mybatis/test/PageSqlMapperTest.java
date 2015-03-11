package com.isea533.mybatis.test;

import com.github.abel533.sql.SqlMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isea533.mybatis.model.Country;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by liuzh on 2015/3/7.
 */
public class PageSqlMapperTest extends BasicTest {

    @Autowired
    private SqlMapper sqlMapper;

    @Test
    public void test(){
        PageHelper.startPage(2,10);
        List<Country> countries = sqlMapper.selectList("select * from country",Country.class);
        PageInfo<Country> pageInfo = new PageInfo<Country>(countries);
        System.out.println(pageInfo.getTotal());
    }
}
