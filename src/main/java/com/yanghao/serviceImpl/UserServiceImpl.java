package com.yanghao.serviceImpl;

import com.yanghao.bean.User;
import com.yanghao.dao.UserRepository;
import com.yanghao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.transaction.TransactionManager;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User login(String username, String password) {
        return userRepository.login(username,password);
    }


    @Override
    public void addUser(String username,String password,String email) {
        userRepository.addUser(username,password,email);
    }


    @Override
    public void delUser(long id) {
        userRepository.delUser(id);
    }


    @Override
    public void udpateUserPwd(long id, String password) {
        userRepository.updateUserPwd(id,password);
    }
}
