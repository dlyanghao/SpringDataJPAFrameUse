package com.yanghao.dao;

import com.yanghao.bean.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * JPA接口
 * BaseRepository
 * CRUD基础功能
 */
@Transactional
public interface UserRepository extends CrudRepository<User,Integer>{

    //查询所有
    public List<User> findAll();

    //根据查询方法名称自动实现查询
    public User getUserByUsernameAndPassword(String username,String password);

    //自定义方法名称，不按照API方法规范，根据HQL(如果要用sql)实现查询，要加入@Query注解
    //如果要用sql进行查询，则让当前nativeQuery=true即可
    //@Query(nativeQuery = true,value = "select * from user where username = ?1 and password = ?2")
    @Query("from User where username = ?1 and password = ?2")
    public User login(String username, String password);

    //自定义方法名称，不按照API方法规范，根据HQL实现增删改，但是要加入@Modifying注解
    @Modifying
    @Query(nativeQuery = true,value = "insert into User values(null,?1,?2,?3)")
    public void addUser(String username,String password,String email);

    @Modifying
    @Query("delete from User where id = ?1")
    public void delUser(long id);

    @Modifying
    @Query("update User set password = ?2 where id =?1")
    public void updateUserPwd(long id,String password);


}
