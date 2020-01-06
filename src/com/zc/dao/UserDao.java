package com.zc.dao;

import com.zc.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 功能描述:用户操作的Dao
 *
 * @Param:
 * @Return:
 * @Author: ZhouCong
 * @Date: 2019/7/28 15:15
 */
public interface UserDao {

    public List<User> findAll();

    public User findUserByUsernameAndPassword(String username , String password);

    public void addUser(User user);

    public  void  deleteUser(Integer id);

    public User findUserById(Integer id);

    public void updateUser(User user);

    public void delSelectedUser(Integer id);
    /**
     * @description: 查询总条数
     * @param condition
     */
    public Integer findTotalCount(Map<String, String[]> condition);

    /**
     * @description: 分页查询list
     *
     */
    public List<User> findByPage(Integer start, Integer rows, Map<String, String[]> condition);
}
