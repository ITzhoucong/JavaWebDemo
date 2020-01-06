package com.zc.dao.impl;

import com.zc.dao.UserDao;
import com.zc.domain.User;
import com.zc.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @auther: ZhouCong
 * @date: Create in 2019/7/28 15:18
 * @description:
 */

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {

            String sql = "select * from user where username = ? and password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addUser(User user) {
//        定义sql
        String sql = "INSERT INTO `user` (`name`,gender,age,address,qq,email) VALUES (?,?,?,?,?,?);";
//       执行sql
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
    }

    @Override
    public void deleteUser(Integer id) {
        String sql = "DELETE FROM `user` WHERE id = ?";
        template.update(sql, id);
    }

    @Override
    public User findUserById(Integer id) {
        String sql = "SELECT * FROM `user` WHERE id = ?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        return user;
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE `user` SET gender = ? , age = ?,address = ? , qq = ? , email = ? WHERE id = ?";
        template.update(sql, user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
    }

    @Override
    public void delSelectedUser(Integer id) {
        String sql = "DELETE FROM `user` WHERE id = ?";
        template.update(sql, id);
    }

    @Override
    public Integer findTotalCount(Map<String, String[]> condition) {
//        1.定义初始化sql
        String sql = "SELECT COUNT(*) FROM user WHERE 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
//        2.遍历map
        Set<String> keySet = condition.keySet();
//        定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
//            排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }

//            获取value,Map的每一个key对应一个数组,我们获取的数组只有一个参数
            String value = condition.get(key)[0];
//            判断value是否有值
            if (value != null && !"".equals(value)) {
//                有值
                sb.append(" AND " + key + " LIKE ?");
                params.add("%" + value + "%");//？条件的值
            }
        }

        Integer totalCount = template.queryForObject(sb.toString(), Integer.class, params.toArray());
        return totalCount;
    }

    @Override
    public List<User> findByPage(Integer start, Integer rows, Map<String, String[]> condition) {

        String sql = "SELECT * FROM user WHERE 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
//        2.遍历map
        Set<String> keySet = condition.keySet();
//        定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
//            排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }

//            获取value,Map的每一个key对应一个数组,我们获取的数组只有一个参数
            String value = condition.get(key)[0];
//            判断value是否有值
            if (value != null && !"".equals(value)) {
//                有值
                sb.append(" AND " + key + " LIKE ? ");
                params.add("%" + value + "%");//？条件的值
            }
        }
//        添加分页查询
        sb.append(" LIMIT ? , ? ");
//        添加分页查询参数值
        params.add(start);
        params.add(rows);
        List<User> list = template.query(sb.toString(), new BeanPropertyRowMapper<User>(User.class), params.toArray());
        return list;
    }

}
