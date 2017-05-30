package dao;

import model.Consumer;

import java.util.List;

public interface ConsumerDao
{
    Consumer getByEmail(String email);

    Consumer getByUsername(String username);

    Consumer getById(int id);

    void add(Consumer consumer);

    List<Consumer> getAll();
}
