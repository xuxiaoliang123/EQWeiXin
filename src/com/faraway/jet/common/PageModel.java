package com.faraway.jet.common;

import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-24
 * Time: 下午9:55
 * To change this template use File | Settings | File Templates.
 */
public class PageModel {
    protected JdbcTemplate jdbcTemplate;
    protected HttpServletRequest request;
    protected HttpServletResponse response;


}
