package com.faraway.business.entity;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-15
 * Time: 下午6:06
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private String userid;
    private String passwd;
    private String loginname;
    private String dept;
    private String description;
    private String iplist;
    private String checkip;
    private String useful;
    private String isleader;
    private String regionid;
    private String username;
    private String owner;
    private String rate;
    private String usertype;
    private String otherinfo;
    private Date createdate;

    public User() {
    }

    public User(String loginname, String username) {
        this.loginname = loginname;
        this.username = username;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIplist() {
        return iplist;
    }

    public void setIplist(String iplist) {
        this.iplist = iplist;
    }

    public String getCheckip() {
        return checkip;
    }

    public void setCheckip(String checkip) {
        this.checkip = checkip;
    }

    public String getUseful() {
        return useful;
    }

    public void setUseful(String useful) {
        this.useful = useful;
    }

    public String getIsleader() {
        return isleader;
    }

    public void setIsleader(String isleader) {
        this.isleader = isleader;
    }

    public String getRegionid() {
        return regionid;
    }

    public void setRegionid(String regionid) {
        this.regionid = regionid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getOtherinfo() {
        return otherinfo;
    }

    public void setOtherinfo(String otherinfo) {
        this.otherinfo = otherinfo;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    @Override
    public String toString() {
        return this.getLoginname()+"("+this.getUsername()+")";
    }
}
