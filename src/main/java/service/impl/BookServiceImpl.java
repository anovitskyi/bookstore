package service.impl;


import dao.CommonDao;
import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CommonService;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements CommonService<Book>
{
    @Autowired
    CommonDao<Book> dao;

    public List<Book> getAll()
    {
        return dao.getAll();
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
