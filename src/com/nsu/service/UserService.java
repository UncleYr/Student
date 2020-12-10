package com.nsu.service;

import com.nsu.bean.User;
import com.nsu.dao.UserDao;

/**
 * @author yr
 * @date 2020/11/16 10:04
 */
public class UserService {
    UserDao userDao = new UserDao();
    public User login(User user){
        return userDao.queryUserByIdAndPassword(user.getId(),user.getPassword());
    }
    public int updatePassword(String id,String password){
        return userDao.updatePassword(new User(id,null,password,null,null,null,null,null));
    }
    public int updateCourse(String id,String course){
        return userDao.updateCourse(new User(id,null,null,null,null,null,null,course));
    }
    public User queryUserById(String id){
        return userDao.queryUserById(id);
    }
}
