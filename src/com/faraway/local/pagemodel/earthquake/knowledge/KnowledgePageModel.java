package com.faraway.local.pagemodel.earthquake.knowledge;

import com.faraway.jet.common.BusinessException;
import com.faraway.jet.common.PageModel;
import net.sf.json.JSONObject;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-1-21
 * Time: ÏÂÎç4:35
 * To change this template use File | Settings | File Templates.
 */
public class KnowledgePageModel extends PageModel {

    public String queryKnowledge()throws BusinessException {
        StringBuffer sb=new StringBuffer();
        SqlRowSet rs=jdbcTemplate.queryForRowSet("select * from eq01 ");
        SqlRowSet rsCount=jdbcTemplate.queryForRowSet("select count(*) from eq01 ");
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
