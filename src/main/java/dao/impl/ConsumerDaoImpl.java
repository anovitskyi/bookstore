package dao.impl;

import dao.DaoImpl;

import model.Consumer;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ConsumerDaoImpl extends DaoImpl<Consumer>
{
    @Override
    public List<Consumer> getAll()
    {
        return session.getCurrentSession().createQuery("from model.Consumer").list();
    }

    @Override
    public Consumer get(int id)
    {
        return (Consumer) session.getCurrentSession().get(Consumer.class, id);
    }
}
