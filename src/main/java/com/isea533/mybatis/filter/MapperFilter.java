package com.isea533.mybatis.filter;

import com.isea533.mybatis.mapper.CountryMapper;
import com.isea533.mybatis.model.Country;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import java.io.IOException;
import java.util.List;

/**
 * @author liuzh
 * @since 2017/10/8.
 */
public class MapperFilter implements Filter {
    @Autowired
    private CountryMapper countryMapper;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        List<Country> countries = countryMapper.selectAll();
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
