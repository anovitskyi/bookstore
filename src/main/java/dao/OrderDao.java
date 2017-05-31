package dao;


import model.ConsumerOrder;

import java.util.List;

public interface OrderDao
{
    ConsumerOrder get(int id);
    List<ConsumerOrder> getAll();

    void add(ConsumerOrder order);
}
