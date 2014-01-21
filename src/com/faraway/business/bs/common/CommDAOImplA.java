package com.faraway.business.bs.common;

import com.faraway.jet.util.noweb.MakeSql;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-1-13
 * Time: 下午7:35
 * To change this template use File | Settings | File Templates.
 */
public class CommDAOImplA implements CommDAO {
    private JdbcTemplate jdbcTemplate;
    public CommDAOImplA(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate=jdbcTemplate;
    }

    @Override
    public String create(Map map, String table) {
        int result=0;
        MakeSql mksql= new MakeSql(this.getColumnData(table));
        mksql.makeInsertSql(map,table,"insert into");
        result=jdbcTemplate.update(mksql.getSql(),mksql.getParamValues());
        return result+"";
    }

    @Override
    public String delete(Map map, String table) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String update(Map map, String table,String wherestamt) {
        int result=0;
        MakeSql mksql= new MakeSql(this.getColumnData(table));
        mksql.makeUpdateSql(map, table);
        result=jdbcTemplate.update(mksql.getSql()+wherestamt,mksql.getParamValues());
        return result+"";
    }

    @Override
    public String find(Map map, String table) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private List<String> getColumnData(String table){
        List<String> list=new ArrayList<String>();
        SqlRowSet srs=jdbcTemplate.queryForRowSet("select * from " + table + " where 1=0");
        SqlRowSetMetaData mtdt=srs.getMetaData();
        for(int i=1;i<=mtdt.getColumnCount();i++){
            list.add(mtdt.getColumnName(i).toLowerCase());
        }
        return list;
    }

}
