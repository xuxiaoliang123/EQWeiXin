package com.faraway.business.bs;

import com.faraway.business.bs.common.CommDAO;
import com.faraway.business.bs.common.CommDAOImplA;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-1-15
 * Time: 上午11:23
 * To change this template use File | Settings | File Templates.
 */
public class JetSelectBusiness {
    private CommDAO commDao;

    public JetSelectBusiness(JdbcTemplate jdbcTemplate) {
        this.commDao =  new CommDAOImplA(jdbcTemplate);
    }

    public String create(Map map,String table){
        return commDao.create(map,table);
    }
    public String update(Map map,String table,String wherestamt){
        return commDao.update(map, table,wherestamt);
    }
}
