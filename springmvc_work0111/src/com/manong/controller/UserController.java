package com.manong.controller;

import com.manong.entity.WUser;
import com.manong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Description:
 *
 * @Author SQB
 * @Date 2021/1/11 11:54
 */
@Controller
@SessionAttributes("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String loginPage(){
        return "login";
    }

    //编写控制器，统一控制页面跳转问题
    @RequestMapping("toPage")
    public String toPage(String page){
        return page;
    }

    //跳转登录
    @RequestMapping("tologin")
    public String tologin(){
        return "login";
    }

    //退出登录
    @RequestMapping("logout")
    public String logout(ModelMap map){
        map.addAttribute("user",new WUser());
        return "login";
    }

    //登录
    @RequestMapping("login")
    public String login(String uname, String upwd, ModelMap map){
        WUser wUser = userService.login(uname, upwd);
        if(wUser != null){
            ModelMap user = map.addAttribute("user", wUser);
            return "index";
        }
        return "login";
    }

    //跳转到前台首页
    @RequestMapping("index")
    public String index(){
        return "index";
    }

    //跳转到修改密码
    @RequestMapping("topwd")
    public String toPwd(HttpSession session, ModelMap map) {
        WUser user = (WUser)session.getAttribute("user");
        map.addAttribute("UserN",user);
        return "pass";
    }

    //动态判断密码是否正确
    @RequestMapping("updpwd")
    @ResponseBody
    public  String orPwd(String ids,HttpServletRequest requst) {
        //获取到登录时的密码
        WUser user = (WUser) requst.getSession().getAttribute("user");
        String uids = user.getUpwd();
        if (uids.equals(ids)){
           return "success";
        }
        return "error";
    }

    //修改密码
    @RequestMapping("updpwds")
    public String updPwd(String renewpass,HttpServletRequest requst){
        WUser user = (WUser) requst.getSession().getAttribute("user");
        int uid = user.getUid();
        userService.updPwd(renewpass,uid);
        return "forward:queAllBook";
    }
}
