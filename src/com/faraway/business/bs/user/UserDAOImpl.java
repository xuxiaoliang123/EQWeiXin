package com.faraway.business.bs.user;

import com.faraway.business.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-15
 * Time: 下午6:00
 * To change this template use File | Settings | File Templates.
 */
public class UserDAOImpl implements UserDAO{

    private JdbcTemplate jdbcTemplate;
    public void setDataSource(DataSource dataSource){
        jdbcTemplate  = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(User user) {
        String sql="insert into jet_user (loginname,username,passwd,createdate) values(?,?,?,current_timestamp)";
        Object[] paramValues={user.getLoginname(),user.getUsername(),user.getPasswd()};
        jdbcTemplate.update(sql,paramValues);
    }

    @Override
    public void delete(User user) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void update(User user) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public User findByName(String loginname) {
        String sql = "SELECT * FROM JET_USER WHERE loginname=?";
        Object[] paramValues = {loginname};
        return (User)jdbcTemplate.queryForObject(sql, paramValues, new UserRowMapper());
    }

    @Override
    public List<User> findAll() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


    //把结果集封装成User对象的包装类
    private static final class UserRowMapper implements RowMapper {
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setLoginname(rs.getString("loginname"));
            user.setUsername(rs.getString("username"));
            user.setPasswd(rs.getString("passwd"));

            return user;
        }
    }
}
