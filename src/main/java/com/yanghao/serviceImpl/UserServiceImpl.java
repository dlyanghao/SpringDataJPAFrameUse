package com.yanghao.serviceImpl;

import com.yanghao.bean.User;
import com.yanghao.dao.UserPagingAndSortingRepository;
import com.yanghao.dao.UserRepository;
import com.yanghao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    @Autowired
    private UserPagingAndSortingRepository userPagingAndSortingRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void setUserPagingAndSortingRepository(UserPagingAndSortingRepository userPagingAndSortingRepository) {
        this.userPagingAndSortingRepository = userPagingAndSortingRepository;
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

    @Override
    public List<User> findAll(int page, int size, Sort.Direction direction) {

        Sort sort = new Sort(direction, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        Page<User> userPage = userPagingAndSortingRepository.findAll(pageable);
        List<User> content = userPage.getContent();
        return content;
    }
}
