package dao.impl;


import dao.OrderDao;
import model.ConsumerOrder;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class OrderDaoImpl implements OrderDao
{
    @Autowired
    private SessionFactory session;

    @Override
    public ConsumerOrder get(int id)
    {
        return (ConsumerOrder) session.getCurrentSession().get(OrderDao.class, id);
    }

    @Override
    public List<ConsumerOrder> getAll()
    {
        return session.getCurrentSession().createQuery("from model.ConsumerOrder").list();
    }

    @Override
    public void add(ConsumerOrder order)
    {
        session.getCurrentSession().save(order);
    }
}
