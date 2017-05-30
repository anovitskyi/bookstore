package dao.impl;

import dao.UserDao;
import model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao
{
    @Autowired
    private SessionFactory session;

    @Override
    public void addUser(User user)
    {
        session.getCurrentSession().save(user);
    }
}
