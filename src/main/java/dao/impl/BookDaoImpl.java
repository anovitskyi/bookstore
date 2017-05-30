package dao.impl;

import dao.BookDao;
import model.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDaoImpl implements BookDao
{

    @Autowired
    private SessionFactory session;

    @Override
    public void add(Book book)
    {
        session.getCurrentSession().saveOrUpdate(book);
    }

    @Override
    public void update(Book book)
    {
        session.getCurrentSession().update(book);
    }

    @Override
    public void delete(Book book)
    {
        session.getCurrentSession().delete(book);
    }

    @Override
    public List<Book> getAll()
    {
        return session.getCurrentSession().createQuery("from model.Book").list();
    }


    @Override
    public Book get(int id)
    {
        return (Book)session.getCurrentSession().get(model.Book.class, id);
    }
}
