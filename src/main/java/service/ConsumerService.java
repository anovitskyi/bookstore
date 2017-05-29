package service;

import model.Consumer;

public interface ConsumerService
{
    Consumer getByEmail(String email);

    void add(Consumer consumer);
}
