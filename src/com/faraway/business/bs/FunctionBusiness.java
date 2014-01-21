package com.faraway.business.bs;

import com.faraway.business.bs.common.CommDAO;
import com.faraway.business.bs.common.CommDAOImplA;
import com.faraway.jet.util.noweb.MakeRandomString;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-1-13
 * Time: 下午8:30
 * To change this template use File | Settings | File Templates.
 */
public class FunctionBusiness {
    private CommDAO commDao;

    public FunctionBusiness(JdbcTemplate jdbcTemplate) {
        this.commDao = new CommDAOImplA(jdbcTemplate);
    }

    public String create(Map map,String table){
        map.put("functionid", MakeRandomString.genString());
        return commDao.create(map,table);
    }
    public String update(Map map,String table,String wherestamt){
        return commDao.update(map, table,wherestamt);
    }
}
