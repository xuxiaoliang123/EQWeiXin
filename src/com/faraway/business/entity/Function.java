package com.faraway.business.entity;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-28
 * Time: 下午1:02
 * To change this template use File | Settings | File Templates.
 */
public class Function {
    private String functionid;
    private String location;
    private String title;
    private String parent;
    private Integer orderno;
    private String type;
    private String description;
    private String log;
    private String developer;
    private String active;
    private String functiondesc;
    private String auflag;
    private String publicflag;
    private String prsource;
    private String rbflag;
    private String param1;
    private String param2;
    private Date createdate;

    public String getFunctionid() {
        return functionid;
    }

    public void setFunctionid(String functionid) {
        this.functionid = functionid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public Integer getOrderno() {
        return orderno;
    }

    public void setOrderno(Integer orderno) {
        this.orderno = orderno;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getFunctiondesc() {
        return functiondesc;
    }

    public void setFunctiondesc(String functiondesc) {
        this.functiondesc = functiondesc;
    }

    public String getAuflag() {
        return auflag;
    }

    public void setAuflag(String auflag) {
        this.auflag = auflag;
    }

    public String getPublicflag() {
        return publicflag;
    }

    public void setPublicflag(String publicflag) {
        this.publicflag = publicflag;
    }

    public String getPrsource() {
        return prsource;
    }

    public void setPrsource(String prsource) {
        this.prsource = prsource;
    }

    public String getRbflag() {
        return rbflag;
    }

    public void setRbflag(String rbflag) {
        this.rbflag = rbflag;
    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}
