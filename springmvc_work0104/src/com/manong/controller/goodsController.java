package com.manong.controller;

import com.manong.entity.Goods;
import com.manong.entity.Students;
import com.manong.service.IGoodsService;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Description:
 *
 * @Author SQB
 * @Date 2021/1/4 16:41
 */

@Controller
public class goodsController {

    @Autowired
    private IGoodsService goodsService;

    //查询所有宿舍
    @RequestMapping("quealls")
    public String queAllGoods(ModelMap map) {
        List<Goods> goods = goodsService.queAllGoods();
        map.put("glist", goods);
        return "goods.jsp";
    }

    //根据id查询要修改宿舍
    @RequestMapping("queById")
    public String queByGoods(ModelMap map,@RequestParam("id") int gid){
        Goods good = goodsService.queById(gid);
        map.put("ByIdlist",good);
        return "goodUpd.jsp";
    }

    //根据id做修改
    @RequestMapping("updGoods")
    public String updByIdGoods(Goods goods){
        goodsService.updGoods(goods);
        return "redirect:quealls";
    }

    //添加宿舍
    @RequestMapping("addGoods")
    public String addGoods(Goods goods){
        goodsService.addGood(goods);
        return "redirect:quealls";
    }

    //得到所有宿舍
    @RequestMapping("queName")
    public String queGoodName(ModelMap map) {
        List<Goods> goods = goodsService.queGoodNames();
        map.put("glist", goods);
        return "studentAdd.jsp";
    }

}