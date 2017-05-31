package service;


import model.ConsumerOrder;

import java.util.List;

public interface OrderService
{
    ConsumerOrder get(int id);
    List<ConsumerOrder> getAll();

    void add(ConsumerOrder order);
}
