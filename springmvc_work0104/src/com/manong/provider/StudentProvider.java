package com.manong.provider;

import javax.sound.midi.MidiChannel;
import java.util.Map;

/**
 * Description:
 *
 * @Author SQB
 * @Date 2021/1/5 14:23
 */
public class StudentProvider {

    //多条件查询
    public String queManyStu(Map map){
        StringBuffer sb = new StringBuffer();
        sb.append("select * from students s inner join goods g on s.goodsId=g.id where 1=1 ");

        Object names = map.get("names");
        if(names!=null && !"".equals(names)){
            sb.append(" and s.name like '%"+names+"%'");
        }
        Object min = map.get("min");
        if(min!=null && !min.equals("")){
            sb.append(" and s.age >= #{min}");
        }

        Object max = map.get("max");
        if(max!=null && !max.equals("")){
            sb.append(" and s.age <= #{max}");
        }

        Object gname = map.get("gname");
        if(gname!=null && !"".equals(gname)){
            sb.append(" and g.id = #{gname}");
        }
        System.out.println(sb);
        return sb.toString();
    }

    //多选删除
    public String delManyStu(Map<String,int[]> map){
        StringBuffer sb = new StringBuffer();
        sb.append("delete from students where id in (");
        int[] mids = map.get("array");
        for (int i : mids) {
            sb.append(i+",");
        }
        System.out.println(sb.substring(0, sb.length() - 1) + ")");

        return  sb.substring(0, sb.length() - 1) + ")";
    }
}
