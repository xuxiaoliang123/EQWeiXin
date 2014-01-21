package com.faraway.local.pagemodel.sysmanager;

import com.faraway.business.bs.FunctionBusiness;
import com.faraway.jet.common.BusinessException;
import com.faraway.jet.common.PageModel;
import com.faraway.jet.util.noweb.ITableName;
import com.faraway.jet.util.noweb.ParameterUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-28
 * Time: 下午8:53
 * To change this template use File | Settings | File Templates.
 */
public class FunctionPageModel extends PageModel {
    public String queryFunction()throws BusinessException {
        StringBuffer sb=new StringBuffer();
        String limit=request.getParameter("limit");
        String start=request.getParameter("start");
        SqlRowSet rs=jdbcTemplate.queryForRowSet("select * from jet_function      limit "+limit+" offset "+start);
        SqlRowSet rsCount=jdbcTemplate.queryForRowSet("select count(*) from jet_function ");
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


    public String queryFunctionTree()throws BusinessException{
        StringBuffer sb=new StringBuffer();
        String node=request.getParameter("node");
        String sql="select b.functionid id,b.title text,b.location value,b.type,b.description,b.ORDERNO,b.nodetype,b.TYPE,b.location," +
                "(select count(1) from jet_function a where b.functionid=a.parent) leafcount  from jet_function   b ";
        if(null==node||"".equals(node)||"root".equals(node)){
            node="businessmenu";
            sql+="where b.parent='"+node+"'";
        }else{
            sql+="where b.parent='"+node+"'";
        }
        Object[] paramValues={node};

        SqlRowSet rs=jdbcTemplate.queryForRowSet(sql);

        SqlRowSetMetaData metaData= rs.getMetaData();
        ArrayList<Map<String,Object>> list=new ArrayList<Map<String, Object>>();
        int columns=metaData.getColumnCount();
        while(rs.next()){
            Map<String,Object> map=new HashMap<String, Object>();
            for(int i=1;i<=columns;i++){
                String columnName=metaData.getColumnName(i).toLowerCase();
                String columnValue=rs.getString(columnName);
                if(columnName.equals("nodetype")){
                    boolean isleaf=rs.getString(columnName).equals("1")?false:true;
                    map.put("leaf",isleaf);
                }
                map.put(columnName.toLowerCase(),columnValue);
            }

            list.add(map);
        }

        String json= JSONArray.fromObject(list).toString();
        return json;
    }

    public String queryFunctionById(){
        StringBuffer sb=new StringBuffer();
        String node=request.getParameter("node");
        String sql="select * from jet_function where functionid='"+node+"' ";

        Object[] paramValues={node};
        SqlRowSet rs=jdbcTemplate.queryForRowSet(sql);

        SqlRowSetMetaData metaData= rs.getMetaData();
        int columns=metaData.getColumnCount();
        Map<String,Object> map=new HashMap<String, Object>();
        if(rs.next()){
            for(int i=1;i<=columns;i++){
                String columnName=metaData.getColumnName(i);
                String columnValue=rs.getString(columnName);
                map.put(columnName.toLowerCase(),columnValue);
            }
        }

        String json= JSONObject.fromObject(map).toString();
        return json;
    }

    public String update(){
        FunctionBusiness fb=new FunctionBusiness(jdbcTemplate);
        Map map=ParameterUtil.toMap(request);
        String result=fb.update(map, ITableName.JET_FUNCTION,"where functionid='"+map.get("functionid")+"'");
        return "{success:"+result+"}";
    }
    public String delete(){
        Object[] paramValues={(String)ParameterUtil.toMap(request).get("functionid")};
        String sql="delete from jet_function where functionid='"+(String)ParameterUtil.toMap(request).get("functionid")+"' ";
        int result=jdbcTemplate.update(sql);
        return "{success:"+result+"}";
    }
    public String create(){
        FunctionBusiness fb=new FunctionBusiness(jdbcTemplate);
        String result=fb.create(ParameterUtil.toMap(request), ITableName.JET_FUNCTION);
        return "{success:"+result+"}";
    }
}
