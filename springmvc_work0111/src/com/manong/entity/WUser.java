package com.manong.entity;

/**
 * Description:
 *
 * @Author SQB
 * @Date 2021/1/11 11:44
 */
public class WUser {

    private int uid;
    private String uname;
    private String upwd;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public WUser() {
    }

    public WUser(int uid, String uname, String upwd) {
        this.uid = uid;
        this.uname = uname;
        this.upwd = upwd;
    }

    @Override
    public String toString() {
        return "WUser{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                '}';
    }
}
