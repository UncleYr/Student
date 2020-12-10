package com.nsu.test;

import com.nsu.bean.Manager;
import com.nsu.bean.User;
import com.nsu.dao.ManagerDao;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author yr
 * @date 2020/11/17 9:38
 */
public class ManagerDaoTest {
ManagerDao managerDao = new ManagerDao();
    @Test
    public void queryUserByUsernameAndPassword() {
    }

    @Test
    public void queryUsers() {
        List<User> users = managerDao.queryUsers();
        for (User user:users){
            System.out.println(user);
        }
    }
    @Test
    public void findProByIndis() throws SQLException {
        List<User> proByIndis = managerDao.findUserByIdAndName("杨9", "173");
        for (User user : proByIndis){
            System.out.println(user);
        }
    }
}