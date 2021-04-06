package com.manong.entity;

import java.util.Date;

   /*
    µÃÂ¿‡
    */
public class Product1028 {
       private int  pid;
       private String pname;
       private double pprice;
       private Date ptime;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getPprice() {
        return pprice;
    }

    public void setPprice(double pprice) {
        this.pprice = pprice;
    }

    public Date getPtime() {
        return ptime;
    }

    public void setPtime(Date ptime) {
        this.ptime = ptime;
    }

    public Product1028(int pid, String pname, double pprice, Date ptime) {
        this.pid = pid;
        this.pname = pname;
        this.pprice = pprice;
        this.ptime = ptime;
    }

    public Product1028() {
    }
}
