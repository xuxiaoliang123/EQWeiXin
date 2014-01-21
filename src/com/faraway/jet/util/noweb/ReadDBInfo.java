package com.faraway.jet.util.noweb;

import net.sf.json.JSONArray;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-28
 * Time: 下午1:09
 * To change this template use File | Settings | File Templates.
 */
public class ReadDBInfo {
    ApplicationContext context=null;
    private String xmlpath="web\\WEB-INF\\db.xml";

    private static Map<String,String> coltype;
    static {
        coltype=new HashMap<String, String>();
        coltype.put("varchar","String");
        coltype.put("varchar2","String");
        coltype.put("char","String");
        coltype.put("number","Integer");
        coltype.put("real","Double");
        coltype.put("date","Date");
    }
    private static String getColtype(String col){
            if(coltype.containsKey(col)){
                return coltype.get(col);
            }else{
                return "String"+" "+col;
            }
    }
    //@Test
    public void test(){
        context=new FileSystemXmlApplicationContext(xmlpath);
        JdbcTemplate jdbcTemplate=(JdbcTemplate)context.getBean("jdbcTemplate");
        SqlRowSet rs=jdbcTemplate.queryForRowSet("select * from jet_role where 1=0");
        SqlRowSetMetaData metaData=rs.getMetaData();

        int count=metaData.getColumnCount();
        for(int i=1;i<count;i++){
            System.out.println("private "+getColtype(metaData.getColumnTypeName(i).toLowerCase())

                    +" "+metaData.getColumnName(i).toLowerCase()+";");
        }
        System.out.println("Hello world");
    }

    @Test
    public void test2(){
        context=new FileSystemXmlApplicationContext(xmlpath);
        JdbcTemplate jdbcTemplate=(JdbcTemplate)context.getBean("jdbcTemplate");
        SqlRowSet rs=jdbcTemplate.queryForRowSet("select * from kf10 where 1=0");
        SqlRowSetMetaData metaData=rs.getMetaData();

        int count=metaData.getColumnCount();
        List<Map> list=new ArrayList<Map>();
        for(int i=1;i<count;i++){
            Map<String,String> map=new HashMap <String,String>();
            map.put("name",metaData.getColumnName(i).toLowerCase());
            list.add(map);
        }
        System.out.println(JSONArray.fromObject(list));
    }
}
