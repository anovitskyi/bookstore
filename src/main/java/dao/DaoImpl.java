package dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

@Transactional
public abstract class DaoImpl<T> implements CommonDao<T>
{
    @Autowired
    protected SessionFactory session;

    public void add(T param)
    {
        session.getCurrentSession().saveOrUpdate(param);
    }

    public void update(T param)
    {
        session.getCurrentSession().update(param);
    }

    public void delete(T param)
    {
        session.getCurrentSession().delete(param);
    }
}
