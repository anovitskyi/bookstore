package dao.impl;

import dao.ConsumerDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import model.Consumer;

import java.util.List;

@Repository
@Transactional
public class ConsumerDaoImpl implements ConsumerDao
{
    @Autowired
    private SessionFactory session;

    @Override
    public Consumer getByEmail(String email)
    {
        return (Consumer) session.getCurrentSession()
                .createQuery("from model.Consumer where email = ?")
                .setParameter(0, email)
                .uniqueResult();
    }

    @Override
    public void add(Consumer consumer)
    {
        session.getCurrentSession().saveOrUpdate(consumer);
    }

    @Override
    public Consumer getById(int id)
    {
        return (Consumer) session.getCurrentSession().get(Consumer.class, id);
    }

    @Override
    public List<Consumer> getAll()
    {
        return session.getCurrentSession().createQuery("from model.Consumer").list();
    }

    @Override
    public Consumer getByUsername(String username)
    {
        return (Consumer) session.getCurrentSession()
                .createQuery("from model.Consumer where username = ?")
                .setParameter(0, username)
                .uniqueResult();
    }
}
