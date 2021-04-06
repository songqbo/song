package com.manong.controller;

import com.manong.entity.Users;
import com.manong.service.IUsersSerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description:
 *
 * @Author SQB
 * @Date 2021/1/6 10:30
 */

@Controller
public class usersController {

    @Autowired
    private IUsersSerService usersSerService;

    //µÇÂ¼½çÃæ
    @RequestMapping("/")
    public String login(){
      return "login.jsp";
    }

    //µÇÂ¼²Ù×÷
    @RequestMapping("queUse")
    public String queUsers(String names,String pwd){
        System.out.println(names);
        Users users = usersSerService.queUsers(names, pwd);
        if (users == null){
            return "login.jsp";
        }else{
            return "aaa.jsp";
        }
    }

}
