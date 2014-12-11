package com.isea533.mybatis.service;

import com.isea533.mybatis.mapperhelper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liuzh on 2014/12/11.
 */
@Service
public class BaseService<T> {

    @Autowired
    protected Mapper<T> mapper;

}
