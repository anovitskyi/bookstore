package dao;

import model.Consumer;

public interface ConsumerDao
{
    Consumer getByEmail(String email);

    void add(Consumer consumer);
}
