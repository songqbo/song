package com.manong.controller;

import com.manong.entity.Books;
import com.manong.service.IHomes;
import com.manong.service.impl.HomesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Description:
 *
 * @Author SQB
 * @Date 2021/3/11 9:33
 */
@Controller
public class HomeController {

    @Autowired
    private IHomes iHomes;

     @RequestMapping("home")
     public String queAll(ModelMap map){
         try {
             List<Books> queall = iHomes.queall();
             System.out.println(queall);
             map.put("book",queall);

         } catch (Exception e){
             e.printStackTrace();
         }
         return "Homes";
     }
}
