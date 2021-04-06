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

    //��д��������ͳһ����ҳ����ת����
    @RequestMapping("toPage")
    public String toPage(String page){
        return page;
    }

    //��ת��¼
    @RequestMapping("tologin")
    public String tologin(){
        return "login";
    }

    //�˳���¼
    @RequestMapping("logout")
    public String logout(ModelMap map){
        map.addAttribute("user",new WUser());
        return "login";
    }

    //��¼
    @RequestMapping("login")
    public String login(String uname, String upwd, ModelMap map){
        WUser wUser = userService.login(uname, upwd);
        if(wUser != null){
            ModelMap user = map.addAttribute("user", wUser);
            return "index";
        }
        return "login";
    }

    //��ת��ǰ̨��ҳ
    @RequestMapping("index")
    public String index(){
        return "index";
    }

    //��ת���޸�����
    @RequestMapping("topwd")
    public String toPwd(HttpSession session, ModelMap map) {
        WUser user = (WUser)session.getAttribute("user");
        map.addAttribute("UserN",user);
        return "pass";
    }

    //��̬�ж������Ƿ���ȷ
    @RequestMapping("updpwd")
    @ResponseBody
    public  String orPwd(String ids,HttpServletRequest requst) {
        //��ȡ����¼ʱ������
        WUser user = (WUser) requst.getSession().getAttribute("user");
        String uids = user.getUpwd();
        if (uids.equals(ids)){
           return "success";
        }
        return "error";
    }

    //�޸�����
    @RequestMapping("updpwds")
    public String updPwd(String renewpass,HttpServletRequest requst){
        WUser user = (WUser) requst.getSession().getAttribute("user");
        int uid = user.getUid();
        userService.updPwd(renewpass,uid);
        return "forward:queAllBook";
    }
}
