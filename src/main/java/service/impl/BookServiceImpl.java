package service.impl;


import dao.BookDao;
import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.BookService;

import java.util.Collections;
import java.util.List;

@Service
public class BookServiceImpl implements BookService
{
    @Autowired
    private BookDao dao;

    public List<Book> getAll()
    {
        List<Book> list = dao.getAll();
        Collections.reverse(list);
        return list;
    }

    public Book get(int id)
    {
        return dao.get(id);
    }

    public void add(Book param)
    {
        dao.add(param);
    }

    public void update(Book param)
    {
        dao.update(param);
    }

    public void delete(Book param)
    {
        dao.delete(param);
    }
}
