package com.manong.entity;


/**
 * Description:
 *
 * @Author SQB
 * @Date 2021/1/4 16:26
 */
public class Students {

    private int sid;
    private String sname;
    private String ssex;
    private int sage;

    private Goods goods;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }


    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Students() {
    }

    public Students(int sid, String sname, String ssex, int sage, Goods goods) {
        this.sid = sid;
        this.sname = sname;
        this.ssex = ssex;
        this.sage = sage;
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "Students{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", sage=" + sage +
                ", goods=" + goods +
                '}';
    }
}
