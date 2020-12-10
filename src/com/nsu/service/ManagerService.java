package com.nsu.service;

import com.nsu.bean.Course;
import com.nsu.bean.Manager;
import com.nsu.bean.User;
import com.nsu.dao.ManagerDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @author yr
 * @date 2020/11/16 14:52
 */
public class ManagerService {
    ManagerDao managerDao = new ManagerDao();
    public Manager login(Manager manager){
        return managerDao.queryUserByUsernameAndPassword(manager.getUsername(),manager.getPassword());
    }
    public void addUser(User user){
        managerDao.addUser(user);
    }
    public void deleteUserById(String id){
        managerDao.deleteUserById(id);
    }
    public void updateUser(User user){
        managerDao.updateUser(user);
    }
    public User queryUserById(String id){
        return managerDao.queryUserById(id);
    }
    public List<User> queryUsers(){
        return managerDao.queryUsers();
    }

    public List<User> findUsersByNameAndId(String name,String id) throws SQLException {
        return managerDao.findUserByIdAndName(name,id);
    }
}

