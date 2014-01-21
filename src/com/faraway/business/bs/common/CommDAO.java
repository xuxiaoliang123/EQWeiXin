package com.faraway.business.bs.common;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-1-13
 * Time: 下午7:31
 * To change this template use File | Settings | File Templates.
 */
public interface CommDAO {
    String create(Map map, String table);

    String delete(Map map, String table);
    String update(Map map, String table, String wherestamt);
    String find(Map map, String table);

}
