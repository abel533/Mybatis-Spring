package com.isea533.mybatis.controller.demo;

import com.github.pagehelper.PageInfo;
import com.isea533.mybatis.model.Country;
import com.isea533.mybatis.model.CountryQueryModel;
import com.isea533.mybatis.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author liuzh_3nofxnp
 * @since 2015-09-19 17:15
 */
@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    private String page_list = "index";

    private String redirect_list = "redirect:list";

    @RequestMapping(value = {"list", "index", "index.html", ""})
    public ModelAndView getList(Country country,
                                @RequestParam(required = false, defaultValue = "1") int page,
                                @RequestParam(required = false, defaultValue = "10") int rows) {
        ModelAndView result = new ModelAndView(page_list);
        List<Country> countryList = countryService.selectByCountry(country, page, rows);
        result.addObject("pageInfo", new PageInfo<Country>(countryList));
        result.addObject("queryParam", country);
        result.addObject("page", page);
        result.addObject("rows", rows);
        return result;
    }

    /**
     * 测试pageinfo，参数必须包含pageNum和pageSize
     * <p/>
     * 这个方法以及调用的相关方法看起来可能很难理解，如果不理解，就不要使用这种方式!
     * <p/>
     * 例如http://[baseurl]/pageInfo?pageNum=1&pageSize=20&countryname=Ch
     *
     * @param queryModel
     * @return
     */
    @RequestMapping(value = "pageInfo", produces = "application/json")
    public ModelAndView pageInfo(CountryQueryModel queryModel) {
        ModelAndView result = new ModelAndView();
        PageInfo<Country> pageInfo = countryService.selectByCountryQueryModel(queryModel);
        result.addObject("pageInfo", pageInfo);
        return result;
    }

    @RequestMapping(value = "view", method = RequestMethod.GET)
    public ModelAndView view(Country country) {
        ModelAndView result = new ModelAndView();
        if (country.getId() != null) {
            country = countryService.selectByKey(country.getId());
        }
        result.addObject("country", country);
        return result;
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ModelAndView save(Country country) {
        ModelAndView result = new ModelAndView(redirect_list);
        if (country.getId() != null) {
            countryService.updateAll(country);
        } else {
            countryService.save(country);
        }
        return result;
    }

    @RequestMapping("delete")
    public String delete(Integer id) {
        countryService.delete(id);
        return redirect_list;
    }

}
