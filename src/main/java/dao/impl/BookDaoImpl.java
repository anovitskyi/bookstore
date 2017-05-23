package dao.impl;

import dao.DaoImpl;
import model.Book;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDaoImpl extends DaoImpl<Book>
{
    public List<Book> getAll()
    {
        return session.getCurrentSession().createQuery("from model.Book").list();
    }

    public Book get(int id)
    {
        return (Book)session.getCurrentSession().get(model.Book.class, id);
    }
}
