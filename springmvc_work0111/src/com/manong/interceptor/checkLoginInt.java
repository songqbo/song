package com.manong.interceptor;

import com.manong.entity.WUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Description:ss  b[
 *
 *
 * @Author SQB
 * @Date 2021/1/11 21:21
 */
public class checkLoginInt extends HandlerInterceptorAdapter {

    private List<String> notInterList;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //将不需要的拦截放行
        String url = request.getServletPath();

        //获取page参数值
        String page = request.getParameter("page");

        if(notInterList.contains(url)||notInterList.contains(url+"?page="+page)){
            return true;
        }

        // 判断用户是否登录成功
        WUser loginUser = (WUser)request.getSession().getAttribute("user");
        if(loginUser==null || loginUser.getUid()==0){
            // 没有登录成功过，跳到登录页面让其重新登录
            response.sendRedirect("toPage?page=login");
            return false;
        }
        // 登录成功过了，放行
        return true;

    }

    public void setNotInterList(List notInterList)
    {
        this.notInterList = notInterList;
    }


}


