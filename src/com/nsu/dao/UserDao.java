package com.nsu.dao;

import com.nsu.bean.User;

/**
 * @author yr
 * @date 2020/11/14 11:44
 */
public class UserDao extends BaseDao{
    public User queryUserByIdAndPassword(String id,String password){
        String sql = "select `id`,`password` from s_user where id=? and password=?";
        return queryForOne(User.class,sql,id,password);
    }
    public int saveUser(User user){
        String sql = "update s_user set password = ? where id =?";
        return update(sql,user.getId(),user.getPassword());
    }
    public int deleteById(Integer id){
        String sql = "delete from s_user where id = ?";
        return update(sql,id);
    }
    public int updatePassword(User user){
        String sql = "update s_user set `password`=? where id = ?";
        return update(sql,user.getPassword(),user.getId());
    }
    public User queryUserById(String id){
        String sql = "select `id`,`username`,`password`,`gender`,`major`,`grade`,`tel`,`course` from s_user where id=?";
        return queryForOne(User.class,sql,id);
    }
    public int updateCourse(User user){
        String sql = "update s_user set `course`=? where id = ?";
        return update(sql,user.getCourse(),user.getId());
    }

}
