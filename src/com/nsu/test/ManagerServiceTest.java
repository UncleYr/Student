package com.nsu.test;

import com.nsu.bean.Manager;
import com.nsu.bean.User;
import com.nsu.service.ManagerService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author yr
 * @date 2020/11/16 15:15
 */
public class ManagerServiceTest {

        ManagerService managerService = new ManagerService();
    @Test
    public void login() {
        Manager manager = managerService.login(new Manager(null, "admin1", "admin"));
        System.out.println(manager);
    }
    @Test
    public void queryUsers(){
        List<User> users = managerService.queryUsers();
        for (User user:users){
            System.out.println(user);
        }
    }
    @Test
    public void addUser(){
        managerService.addUser(new User("1731090111","小杨","111111","男","信工","17级","110",null));

    }
    @Test
    public void updateUser(){
        managerService.updateUser(new User("121212","小杨","111111","男","信工","17级","110",null));
    }
    @Test
    public void queryUserById(){
        User user = managerService.queryUserById("111111");
        System.out.println(user);
    }
}