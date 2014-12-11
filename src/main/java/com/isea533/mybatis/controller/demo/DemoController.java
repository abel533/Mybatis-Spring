package com.isea533.mybatis.controller.demo;

import com.isea533.mybatis.model.Country;
import com.isea533.mybatis.model.Country2;
import com.isea533.mybatis.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author liuzh
 */
@Controller
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping(value = {"/", "index.html"})
    public String index() {
        return "index";
    }

    @ResponseBody
    @RequestMapping("test1")
    public Country requestTest5(HttpEntity<String> message) {
        return demoService.selectById(35);
    }

    @RequestMapping("test2")
    public ResponseEntity<Country> requestTest6() {
        return new ResponseEntity<Country>(demoService.selectById2(35), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping("test3")
    public List<Country2> requestTest7(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        return demoService.selectPage2(pageNum, pageSize);
    }
}
