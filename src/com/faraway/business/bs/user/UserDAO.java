package com.faraway.business.bs.user;

import com.faraway.business.entity.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-15
 * Time: 下午6:07
 * To change this template use File | Settings | File Templates.
 */
public interface UserDAO {
    void create(User user);
    /** 删除指定账户 */
    void delete(User user);
    /** 更新账户 */
    void update(User user);
    /** 查询指定ID的账户 */
    User findByName(String loginname);
    /** 查询所有账户 */
    List<User> findAll();
}
