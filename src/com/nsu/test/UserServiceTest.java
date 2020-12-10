package com.nsu.test;

import com.nsu.bean.User;
import com.nsu.service.UserService;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yr
 * @date 2020/11/17 19:10
 */
public class UserServiceTest {
UserService userService = new UserService();
    @Test
    public void login() {
    }

    @Test
    public void updatePassword() {
    }
    @Test
    public void updateCourse() {
        userService.updateCourse("111111","电影欣赏");
    }
    @Test
    public void queryUserById() {
        User user = userService.queryUserById("111111");
        System.out.println(user);
    }
}