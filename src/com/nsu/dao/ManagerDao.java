package com.nsu.dao;

import com.nsu.bean.Course;
import com.nsu.bean.Manager;
import com.nsu.bean.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yr
 * @date 2020/11/16 8:57
 */
public class ManagerDao extends BaseDao {
    public Manager queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select `username`,`password` from s_manager where username=? and password=?";
        return queryForOne(Manager.class, sql, username, password);
    }

    public List<User> queryUsers() {
        String sql = "select `id`,`username`,`password`,`gender`,`major`,`grade`,`tel`,`course` from s_user";
        return queryForList(User.class, sql);
    }

    public User queryUserById(String id) {
        String sql = "select `id`,`username`,`password`,`gender`,`major`,`grade`,`tel`,`course` from s_user where id = ?";
        return queryForOne(User.class, sql, id);
    }

    public int updateUser(User user) {
        String sql = "update s_user set`username`=?,`password`=?,`gender`=?,`major`=?,`grade`=?,`tel`=?,`course`=? where id=?";
        return update(sql, user.getUsername(), user.getPassword(), user.getGender(), user.getMajor(), user.getGrade(), user.getTel(), user.getCourse(), user.getId());
    }

    public int deleteUserById(String id) {
        String sql = "delete from s_user where id = ?";
        return update(sql, id);
    }

    public int addUser(User user) {
        String sql = "insert into s_user(`id`,`username`,`password`,`gender`,`major`,`grade`,`tel`,`course`) values(?,?,?,?,?,?,?,?)";
        return update(sql, user.getId(),user.getUsername(), user.getPassword(), user.getGender(), user.getMajor(), user.getGrade(), user.getTel(), user.getCourse());
    }

    /**
     * 通过用户输入的参数，到数据库中查询到商品信息，并以集合的方式返回
     *
     * @param username 传入的查询参数
     * @param id 传入的查询参数
     * @return 返回一个集合，其集合由实体Product组成
     * @throws SQLException
     */
    public List<User> findUserByIdAndName(String username, String id) throws SQLException {
        //创建dbutils下的QueryRunnner
        //QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
        //☆☆☆注意where 1=1后面一定要留空格，否则和后面进行字符串拼接后，到数据库查询会出现错误
        String sql = "select * from s_user where 1=1 ";
        //创建一个集合用来存储查询的参数，因为我们不清楚客户到底输入几个参数，所以用集合来存放
        List<String> list = new ArrayList<String>();
        if (username != "") {
            //如果用户输入的name不为空，那需要进行字符串拼接
            sql += "and username like ? ";
            //将用户输入的参数添加到集合
            list.add("%" + username + "%");
        }
        if (id != "") {
            sql += "and id like ? ";
            list.add("%" + id + "%");
        }
        //最后将集合转化成数组
        Object[] params = list.toArray();
        //调用runner对象的query查询方法，并将集合返回
        //return runner.query(sql, new BeanListHandler<User>(User.class), params);
        return queryForList(User.class,sql,list.toArray());
    }
}
