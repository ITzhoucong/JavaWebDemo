package com.zc.service.impl;

import com.zc.dao.UserDao;
import com.zc.dao.impl.UserDaoImpl;
import com.zc.domain.PageBean;
import com.zc.domain.User;
import com.zc.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * @auther: ZhouCong
 * @date: Create in 2019/7/28 15:14
 * @description:
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User login(User user) {

        return userDao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }

    @Override
    public User findUserById(Integer id) {
        User userById = userDao.findUserById(id);

        return userById;
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void delSelectedUser(String[] ids) {
        if (ids != null && ids.length>0){

//        遍历数组
        for (String id : ids){
//         调用dao
            userDao.delSelectedUser(Integer.parseInt(id));
        }
        }
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {

        Integer currentPage = Integer.parseInt(_currentPage);
        Integer rows = Integer.parseInt(_rows);


//        1.创建空的PageBean对象
        PageBean<User> pb = new PageBean<>();

//        3.调用dao查询总记录数
        Integer totalCount = userDao.findTotalCount(condition);
        pb.setTotalCount(totalCount);

        //        5.计算总页码
        Integer totalPage = (totalCount % rows)  == 0 ? (totalCount/rows) : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);


        if (currentPage <=0){
            currentPage = 1;
        }else
        if (currentPage >= totalPage + 1){
            currentPage = totalPage;
        }
        //        2.设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

//        4.调用dao查询list集合
//        计算开始的记录索引
        Integer start = (currentPage - 1) * rows;
        List<User> list = userDao.findByPage(start,rows,condition);


        pb.setList(list);

        return pb;

    }


}
