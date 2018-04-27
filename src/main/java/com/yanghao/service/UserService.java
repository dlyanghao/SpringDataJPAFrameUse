package com.yanghao.service;

import com.yanghao.bean.User;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface UserService {

    //基本查询（接口实现了CRUDRepository）
    public List<User> getAll();
    public User login(String username,String password);

    public void addUser(String username,String password,String email);
    public void delUser(long id);
    public void udpateUserPwd(long id, String password);


    //分页查询(接口实现了PagingAndSortingRepository)
    public List<User> findAll(int page, int size, Sort.Direction direction);
}
