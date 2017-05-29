package dao;

import model.Book;

import java.util.List;

public interface BookDao
{
    List<Book> getAll();
    Book get(int id);

    void add(Book book);
    void update(Book book);
    void delete(Book book);
}
