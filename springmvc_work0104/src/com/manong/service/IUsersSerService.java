package com.manong.service;

import com.manong.entity.Users;

/**
 * Description:
 *
 * @Author SQB
 * @Date 2021/1/6 10:31
 */
public interface IUsersSerService {

    //查询是否有此用户
    public Users queUsers(String names, String pwd);

}
