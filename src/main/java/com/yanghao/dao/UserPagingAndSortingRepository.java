package com.yanghao.dao;

import com.yanghao.bean.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserPagingAndSortingRepository extends PagingAndSortingRepository<User,Integer>{


}
