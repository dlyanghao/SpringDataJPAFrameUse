package com.yanghao.service;

import com.yanghao.bean.User;

import java.util.List;

public interface UserService {

    public List<User> getAll();
    public User login(String username,String password);

    public void addUser(String username,String password,String email);
    public void delUser(long id);
    public void udpateUserPwd(long id, String password);

}
