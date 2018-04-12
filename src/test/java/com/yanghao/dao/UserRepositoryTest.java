package com.yanghao.dao;


import com.yanghao.bean.User;
import com.yanghao.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserRepositoryTest {

    @Autowired
    private UserService userService;

    //BaseRepository增删查改的测试
    @Test
    public void testGetAll(){
        List<User> all = userService.getAll();
        System.out.println(all);
    }

    @Test
    public void testLogin(){

        User user = userService.login("dlyanghao", "7773365");
        System.out.println(user);
    }

    @Test
    public void testAddUser(){
        userService.addUser("testUsername","testPassword","testEmail");
    }

    @Test
    public void testDelUser(){
        userService.delUser(42);
    }

    @Test
    public void updateUser(){
        userService.udpateUserPwd(1,"123456");
    }

}
