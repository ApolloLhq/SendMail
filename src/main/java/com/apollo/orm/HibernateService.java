package com.apollo.orm;

import com.apollo.entity.TUser;

import java.util.List;

public interface HibernateService {
    /**
     * 添加用户
     */
    public void insertUser(TUser user);
    /**
     * 更新用户
     */
    public void updateUser(TUser user);
    /**
     * 查询用户
     */
    public List<TUser> selectUser();
    /**
     * 删除用户
     */
    public void deleteUser(Integer id);
}
