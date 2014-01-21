package com.faraway.jet.util.noweb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-1-13
 * Time: 下午8:01
 * To change this template use File | Settings | File Templates.
 */
public class MakeSql {
    private List<String> list;
    private List<Object> paramList=new ArrayList<Object>();
    private String sql;
    /*
    list为表结构字段名称的集合
     */
    public MakeSql(List<String> list) {
        this.list=list;
    }

    public void makeInsertSql(Map map, String table,String insertOrReplace){
        String col_str="";
        String val_str="";
        Iterator iter = map.keySet().iterator();
        while (iter.hasNext()) {
            String key = iter.next().toString();
            if(null!=list&&!list.contains(key)){
                continue;
            }
            String val = map.get(key).toString();
            val_str+="?,";
            col_str+=key+",";
            paramList.add(val);

        }
        col_str.length();
        col_str=col_str.substring(0,col_str.length()-1);
        val_str=val_str.substring(0,val_str.length()-1);

        sql=  insertOrReplace+" " + table +
                " ("+col_str+") values " +"("+val_str+")";

    }

    /*
    不包含where语句,请自行追加
     */
    public void makeUpdateSql(Map map, String table){
        String str="";
        int result=0;
        Iterator iter = map.keySet().iterator();
        while (iter.hasNext()) {
            String key = iter.next().toString();
            if(null!=list&&!list.contains(key)){
                continue;
            }
            String val = map.get(key).toString();
            paramList.add(val);
            str+=key+"=?,";

        }
        str=str.substring(0,str.length()-1);
        sql= "update " + table +" set "+str+" ";
    }

    public Object[] getParamValues() {
        return paramList.toArray();
    }

    public String getSql() {
        return sql;
    }
}
