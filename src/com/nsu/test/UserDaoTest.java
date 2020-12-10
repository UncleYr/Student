package com.nsu.test;

import com.nsu.bean.User;
import com.nsu.dao.UserDao;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yr
 * @date 2020/11/16 9:46
 */
public class UserDaoTest {
UserDao user = new UserDao();
    @Test
    public void queryUserByIdAndPassword() {
        if (user.queryUserByIdAndPassword("17310920111","111111")==null){
            System.out.println("学号或者密码错误,登陆失败");
        }
        else {
            System.out.println("登陆成功！");
        }
    }

    @Test
    public void saveUser() {

    }
    @Test
    public void updateUser(){
        user.updatePassword(new User("17310920112",null,"123456",null,null,null,null,null));
    }


}