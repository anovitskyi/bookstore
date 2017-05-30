package service;

import model.Consumer;

import java.util.List;

public interface ConsumerService
{
    Consumer getByEmail(String email);

    Consumer getById(int id);

    Consumer getByUsername(String username);

    void add(Consumer consumer);

    List<Consumer> getAll();
}
