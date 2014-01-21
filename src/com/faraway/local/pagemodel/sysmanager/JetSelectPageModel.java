package com.faraway.local.pagemodel.sysmanager;

import com.faraway.business.bs.JetSelectBusiness;
import com.faraway.jet.common.PageModel;
import com.faraway.jet.util.noweb.ParameterUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-1-14
 * Time: 下午7:34
 * To change this template use File | Settings | File Templates.
 */
public class JetSelectPageModel extends PageModel {

    public String select(){
        String aaz001=request.getParameter("aaz001");
        String sql=  "select aaz002,aaz003  from kf10 where aaz001 = ?";
        Object[] paramValues={aaz001};
        SqlRowSet sqlRowSet=jdbcTemplate.queryForRowSet(sql, paramValues);
        ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        while (sqlRowSet.next()) {
            Map<String,Object> obj=new HashMap<String, Object>();
            obj.put("aaz002",sqlRowSet.getString("aaz002"));
            obj.put("aaz003",sqlRowSet.getString("aaz003"));
            list.add(obj);
        }
        return JSONArray.fromObject(list).toString();
    }

    public String save(){
        Map map= ParameterUtil.toMap(request);
        String aaz101=map.get("aaz101").toString();
        JetSelectBusiness js=new JetSelectBusiness(jdbcTemplate);
        if("-1".equals(aaz101)){
            map.remove("aaz101");
            map.put("aaz101",new Date().getTime());
            js.create(map,"kf09");
        }else{
            js.update(map,"kf09","where aaz101='"+aaz101+"'");
        }
        System.out.println(map);
        return "";
    }
    public String savekf10(){
        Map map= ParameterUtil.toMap(request);
        String aaz001=map.get("aaz001").toString();
        JetSelectBusiness js=new JetSelectBusiness(jdbcTemplate);
        js.create(map,"kf10");
        System.out.println(map);
        return "";
    }

    public String queryKf09(){
        StringBuffer sb=new StringBuffer();

        SqlRowSet rs=jdbcTemplate.queryForRowSet("select * from kf09");
        SqlRowSet rsCount=jdbcTemplate.queryForRowSet("select count(*) from kf09 ");
        int totalCount=0;
        if(rsCount.next()){
            totalCount=rsCount.getInt(1);
        }
        SqlRowSetMetaData metaData= rs.getMetaData();
        ArrayList<Map<String,Object>> list=new ArrayList<Map<String, Object>>();
        int columns=metaData.getColumnCount();
        while(rs.next()){
            Map<String,Object> map=new HashMap<String, Object>();
            for(int i=1;i<=columns;i++){
                String columnName=metaData.getColumnName(i);
                String columnValue=rs.getString(columnName);
                map.put(columnName.toLowerCase(),columnValue);
            }
            list.add(map);
        }
        Map<String,Object>res=new HashMap<String, Object>();
        res.put("totalCount",totalCount);
        res.put("success",true);
        res.put("results",list);
        return JSONObject.fromObject(res).toString();

    }

    public String queryKf10(){
        StringBuffer sb=new StringBuffer();
        Map map0= ParameterUtil.toMap(request);
        String aaz001=map0.get("aaz001").toString();
        if(null==aaz001&&"".equals(aaz001)){
            return "输入参数aaz001";
        }
        SqlRowSet rs=jdbcTemplate.queryForRowSet("select * from kf10 where aaz001='"+aaz001+"'");
        SqlRowSet rsCount=jdbcTemplate.queryForRowSet("select count(*) from kf10 where aaz001='"+aaz001+"'");
        int totalCount=0;
        if(rsCount.next()){
            totalCount=rsCount.getInt(1);
        }
        SqlRowSetMetaData metaData= rs.getMetaData();
        ArrayList<Map<String,Object>> list=new ArrayList<Map<String, Object>>();
        int columns=metaData.getColumnCount();
        while(rs.next()){
            Map<String,Object> map=new HashMap<String, Object>();
            for(int i=1;i<=columns;i++){
                String columnName=metaData.getColumnName(i);
                String columnValue=rs.getString(columnName);
                map.put(columnName.toLowerCase(),columnValue);
            }
            list.add(map);
        }
        Map<String,Object>res=new HashMap<String, Object>();
        res.put("totalCount",totalCount);
        res.put("success",true);
        res.put("results",list);
        return JSONObject.fromObject(res).toString();

    }
}
