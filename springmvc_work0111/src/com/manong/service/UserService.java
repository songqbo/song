package com.manong.service;

import com.manong.entity.WUser;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @Author SQB
 * @Date 2021/1/11 12:01
 */

public interface UserService {

    //��¼
    public WUser login(String name, String pwd);

    //�޸�����
    public void updPwd(String pwd,int id);

}
