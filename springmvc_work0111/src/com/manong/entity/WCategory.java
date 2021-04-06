package com.manong.entity;

import java.util.List;

/**
 * Description:
 *
 * @Author SQB
 * @Date 2021/1/11 11:44
 */
public class WCategory {

    private int cid;
    private String cname;
    private List<WBook> wBooks;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public List<WBook> getwBooks() {
        return wBooks;
    }

    public void setwBooks(List<WBook> wBooks) {
        this.wBooks = wBooks;
    }

    public WCategory() {
    }

    public WCategory(int cid, String cname, List<WBook> wBooks) {
        this.cid = cid;
        this.cname = cname;
        this.wBooks = wBooks;
    }
}
