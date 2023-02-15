package com.apollo.orm;

import com.apollo.dao.UserDao;
import com.apollo.entity.TUser;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class HibernateServiceImpl implements HibernateService{

    @Autowired
    private UserDao userDao;
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public SessionFactory getSessionFactory() {
        return entityManagerFactory.unwrap(SessionFactory.class);
    }

    @Transactional
    @Override
    public void insertUser(TUser user) {
        userDao.save(user);
        // int num = 1/0;  //放开测试事务。预期结果为添加失败，库中无数据。测试结果与预期一致
    }

    @Override
    public void updateUser(TUser user) {
        userDao.save(user);
    }

    @Override
    public List<TUser> selectUser() {
        String sql = "SELECT u FROM TUser u WHERE send = 0";
        @SuppressWarnings("unchecked")
        List<TUser> resultList = getSessionFactory().openSession()
                .createQuery(sql)
                .getResultList();
        // userDao.findName1("张三");
        return resultList;
    }

    @Transactional
    @Override
    public void deleteUser(Integer id) {
        userDao.deleteById(id);
    }
}
