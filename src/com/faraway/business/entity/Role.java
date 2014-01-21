package com.faraway.business.entity;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-28
 * Time: 下午1:47
 * To change this template use File | Settings | File Templates.
 */
public class Role {
    private String roleid;
    private String roledesc;
    private String parent;
    private String owner;
    private String rolename;
    private String status;

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getRoledesc() {
        return roledesc;
    }

    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
