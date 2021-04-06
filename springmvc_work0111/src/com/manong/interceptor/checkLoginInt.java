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

        //������Ҫ�����ط���
        String url = request.getServletPath();

        //��ȡpage����ֵ
        String page = request.getParameter("page");

        if(notInterList.contains(url)||notInterList.contains(url+"?page="+page)){
            return true;
        }

        // �ж��û��Ƿ��¼�ɹ�
        WUser loginUser = (WUser)request.getSession().getAttribute("user");
        if(loginUser==null || loginUser.getUid()==0){
            // û�е�¼�ɹ�����������¼ҳ���������µ�¼
            response.sendRedirect("toPage?page=login");
            return false;
        }
        // ��¼�ɹ����ˣ�����
        return true;

    }

    public void setNotInterList(List notInterList)
    {
        this.notInterList = notInterList;
    }


}


