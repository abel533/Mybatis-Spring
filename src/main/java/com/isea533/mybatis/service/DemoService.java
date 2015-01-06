/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.isea533.mybatis.service;

import com.github.abel533.mapper.Mapper;
import com.isea533.mybatis.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuzh
 */
@Service
public class DemoService extends BaseService<Country>{

    @Autowired
    private Mapper<Country> countryMapper;

    public int save(Country country) {
        if (country == null) {
            throw new NullPointerException("保存的对象不能为空!");
        }
        if (country.getCountrycode() == null || country.getCountrycode().equals("")) {
            throw new RuntimeException("国家代码不能为空!");
        }
        if (country.getCountryname() == null || country.getCountryname().equals("")) {
            throw new RuntimeException("国家名称不能为空!");
        }
        return super.save(country);
    }

    public void test(){
        int result = countryMapper.selectCount(null);
        System.out.println(result);
    }

}
