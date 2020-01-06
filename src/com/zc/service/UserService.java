package com.zc.service;

import com.zc.domain.PageBean;
import com.zc.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 功能描述:用户管理业务接口
 *
 * @Param:
 * @Return:
 * @Author: ZhouCong
 * @Date: 2019/7/28 15:11
 */
public interface UserService {
    public List<User> findAll();

    /**
     * @description: 登录用户
     *
     */
    public User login(User user);

    /**
     * @description: 添加用户
     *
     */
    public void addUser(User user);

    /**
     * @description: 删除用户
     *
     */
    public void deleteUser(Integer id);

    /**
     * @description: 用户信息回显
     *
     */
    public User findUserById(Integer id);

    /**
     * @description: 修改用户信息
     *
     */
    public void updateUser(User user);

    /**
     * @description: 批量删除用户
     *
     */
    public void delSelectedUser(String[] ids);

/**
 * @description: 分页条件查询
 *
 */
    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
