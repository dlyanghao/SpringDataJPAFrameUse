package com.yanghao.dao;


import com.yanghao.bean.User;
import com.yanghao.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserPagingAndSortingRepositoryTest {

    @Autowired
    private UserService userService;


    @Test
    public void testFindAll(){
        List<User> all = userService.findAll(0, 5, Sort.Direction.ASC);
        for (User user: all
             ) {
            System.out.println(user);
        }
    }
}
