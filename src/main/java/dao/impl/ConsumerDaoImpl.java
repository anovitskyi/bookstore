package dao.impl;

import dao.ConsumerDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import model.Consumer;

@Repository
@Transactional
public class ConsumerDaoImpl implements ConsumerDao
{
    @Autowired
    protected SessionFactory session;

    @Override
    public Consumer getByEmail(String email)
    {
        return (Consumer) session.getCurrentSession().createQuery("from model.Consumer where email = ?");
    }

    @Override
    public void add(Consumer consumer)
    {
        session.getCurrentSession().save(consumer);
    }
}
