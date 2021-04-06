package com.manong.controller;

import com.manong.entity.Goods;
import com.manong.entity.Students;
import com.manong.service.IGoodsService;
import com.manong.service.IStudentsService;
import com.sun.deploy.net.HttpResponse;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @Author SQB
 * @Date 2021/1/4 22:08
 */
@Controller
public class studentsController {

    @Autowired
    private IStudentsService studentsService;

    @Autowired
    private IGoodsService goodsService;

    //��ѯ��������
    @RequestMapping("queallGood")
    public String queAllGoods(ModelMap map) {
        List<Goods> goods = goodsService.queAllGoods();
        map.put("glist", goods);
        return "students.jsp";
    }

    //��ѯ����ѧ��
    @RequestMapping("queallstu")
    public String queAllStus(ModelMap map) {
        List<Students> students = studentsService.queAllStu();
        map.put("slist",students);
        return "queallGood";
    }

    //���ѧ��
    @RequestMapping("addStu")
    public String addStus(Students students){
        System.out.println(students);
        studentsService.addStu(students);
        return "queallstu";
    }

    //��������ѯ
    @RequestMapping("queMany")
    public String queManys(@RequestParam Map map,ModelMap map2){
        List<Students> students = studentsService.queManys(map);
        map2.put("slist",students);
        map2.put("names",map.get("names"));
        map2.put("min",map.get("min"));
        map2.put("max",map.get("max"));
        map2.put("gname",map.get("gname"));
        return "queallGood";
    }

    //����id��ɾ��
    @RequestMapping("delStu")
    @ResponseBody
    public String delStus(int id,ModelMap map){
        int count = studentsService.delStu(id);
        if (count == 1){
           return "success";
        }else{
            return null;
        }
    }

    //��ѡɾ��
    @RequestMapping("delmuch")
    @ResponseBody
    public String delMuch( int[] mid){
        int num = studentsService.delManys(mid);
        if(num!=0){
            return "success";
        }
        return "error";
    }

}




