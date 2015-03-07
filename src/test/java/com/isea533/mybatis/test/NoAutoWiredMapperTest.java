package com.isea533.mybatis.test;

import com.isea533.mybatis.mapper.UserInfoMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by liuzh on 2015/3/7.
 */
public class NoAutoWiredMapperTest extends BasicTest {

    @Autowired
    private SqlSession sqlSession;

    @Test
    public void test(){
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        int count = userInfoMapper.selectCount(null);
        System.out.println(count);
    }
}
