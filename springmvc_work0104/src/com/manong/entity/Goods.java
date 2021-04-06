package com.manong.entity;


import java.util.List;

/**
 * Description:
 *
 * @Author SQB
 * @Date 2021/1/4 16:24
 */
public class Goods {

     private int gid;
     private String gname;
     private String gaddress;
     private int gpeoples;

     private List<Students> students;

     public int getGid() {
          return gid;
     }

     public void setGid(int gid) {
          this.gid = gid;
     }

     public String getGname() {
          return gname;
     }

     public void setGname(String gname) {
          this.gname = gname;
     }

     public String getGaddress() {
          return gaddress;
     }

     public void setGaddress(String gaddress) {
          this.gaddress = gaddress;
     }

     public int getGpeoples() {
          return gpeoples;
     }

     public void setGpeoples(int gpeoples) {
          this.gpeoples = gpeoples;
     }

     public List<Students> getStudents() {
          return students;
     }

     public void setStudents(List<Students> students) {
          this.students = students;
     }

     public Goods() {
     }

     public Goods(int gid, String gname, String gaddress, int gpeoples, List<Students> students) {
          this.gid = gid;
          this.gname = gname;
          this.gaddress = gaddress;
          this.gpeoples = gpeoples;
          this.students = students;
     }

     @Override
     public String toString() {
          return "Goods{" +
                  "gid=" + gid +
                  ", gname='" + gname + '\'' +
                  ", gaddress='" + gaddress + '\'' +
                  ", gpeoples=" + gpeoples +
                  '}';
     }
}
