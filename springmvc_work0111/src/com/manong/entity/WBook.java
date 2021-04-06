package com.manong.entity;

/**
 * Description:
 *
 * @Author SQB
 * @Date 2021/1/11 11:45
 */
public class WBook {

    private int bid;
    private String bname;
    private String bauthor;
    private double bprice;
    private String bpicname;
    private String bpictime;

    private WCategory wCategory;

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBauthor() {
        return bauthor;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public double getBprice() {
        return bprice;
    }

    public void setBprice(double bprice) {
        this.bprice = bprice;
    }

    public WCategory getwCategory() {
        return wCategory;
    }

    public void setwCategory(WCategory wCategory) {
        this.wCategory = wCategory;
    }

    public String getBpicname() {
        return bpicname;
    }

    public void setBpicname(String bpicname) {
        this.bpicname = bpicname;
    }

    public String getBpictime() {
        return bpictime;
    }

    public void setBpictime(String bpictime) {
        this.bpictime = bpictime;
    }

    public WBook() {
    }

    public WBook(int bid, String bname, String bauthor, double bprice, String bpicname, String bpictime, WCategory wCategory) {
        this.bid = bid;
        this.bname = bname;
        this.bauthor = bauthor;
        this.bprice = bprice;
        this.bpicname = bpicname;
        this.bpictime = bpictime;
        this.wCategory = wCategory;
    }

    @Override
    public String toString() {
        return "WBook{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                ", bauthor='" + bauthor + '\'' +
                ", bprice=" + bprice +
                ", bpicname='" + bpicname + '\'' +
                ", bpictime='" + bpictime + '\'' +
                ", wCategory=" + wCategory +
                '}';
    }
}
