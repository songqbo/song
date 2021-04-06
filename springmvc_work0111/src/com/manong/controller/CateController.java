package com.manong.controller;

import com.manong.entity.WCategory;
import com.manong.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Description:
 *
 * @Author SQB
 * @Date 2021/1/11 17:31
 */
@Controller
public class CateController {

    @Autowired
    private CategoryService categoryService;

    //查询所有类别
    @RequestMapping("queAllCate")
    public String queAllCate(ModelMap map){

        List<WCategory> wCategories = categoryService.queAllCate();
        map.put("clist",wCategories);
        return "book";

    }
}
