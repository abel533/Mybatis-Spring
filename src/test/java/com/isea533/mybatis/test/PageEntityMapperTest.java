package com.isea533.mybatis.test;

import com.github.abel533.entity.EntityMapper;
import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isea533.mybatis.model.Country;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by liuzh on 2015/3/7.
 */
public class PageEntityMapperTest extends BasicTest {

    @Autowired
    private EntityMapper entityMapper;

    @Test
    public void test(){
        Example example = new Example(Country.class);
        example.createCriteria().andGreaterThan("id",100);
        PageHelper.startPage(2,10);
        List<Country> countries = entityMapper.selectByExample(example);
        PageInfo<Country> pageInfo = new PageInfo<Country>(countries);
        System.out.println(pageInfo.getTotal());
    }
}
