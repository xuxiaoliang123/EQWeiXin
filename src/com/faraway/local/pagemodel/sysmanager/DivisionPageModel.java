package com.faraway.local.pagemodel.sysmanager;

import com.faraway.jet.common.BusinessException;
import com.faraway.jet.common.PageModel;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-28
 * Time: 下午4:19
 * To change this template use File | Settings | File Templates.
 */
public class DivisionPageModel extends PageModel {

    public String queryDivision()throws BusinessException{
        StringBuffer sb=new StringBuffer();
        String limit=request.getParameter("limit");
        String start=request.getParameter("start");
        SqlRowSet rs=jdbcTemplate.queryForRowSet("select * from ZONE      limit "+limit+" offset "+start);
        SqlRowSet rsCount=jdbcTemplate.queryForRowSet("select count(*) from zone ");
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


    public String queryDivisionTree()throws BusinessException{
        StringBuffer sb=new StringBuffer();
        String zon148=request.getParameter("node");
        String sql="select b.zon301 id,b.zon146 text,b.zon301 value,(select count(1) from ZONE a where b.zon301=a.zon148) leafcount  from zone   b ";
        if(null==zon148||"".equals(zon148)||"root".equals(zon148)){
            zon148="330000";
            sql+="where b.zon301='"+zon148+"'";
        }else{
            sql+="where b.zon148='"+zon148+"'";
        }
        Object[] paramValues={zon148};

        SqlRowSet rs=jdbcTemplate.queryForRowSet(sql);

        SqlRowSetMetaData metaData= rs.getMetaData();
        ArrayList<Map<String,Object>> list=new ArrayList<Map<String, Object>>();
        int columns=metaData.getColumnCount();
        while(rs.next()){
            Map<String,Object> map=new HashMap<String, Object>();
            for(int i=1;i<=columns;i++){
                String columnName=metaData.getColumnName(i);
                String columnValue=rs.getString(columnName);
                if(columnName.equals("leafcount")){
                    boolean isleaf=rs.getInt(columnName)>0?false:true;
                    map.put("leaf",isleaf);
                }
                map.put(columnName.toLowerCase(),columnValue);
            }

            list.add(map);
        }

        String json=JSONArray.fromObject(list).toString();
        System.out.println(json);
        return json;
    }
}
