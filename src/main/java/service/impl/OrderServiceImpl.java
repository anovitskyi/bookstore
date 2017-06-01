package service.impl;


import dao.OrderDao;
import model.ConsumerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService
{

    @Autowired
    private OrderDao dao;

    @Override
    public ConsumerOrder get(int id)
    {
        return dao.get(id);
    }

    @Override
    public List<ConsumerOrder> getAll()
    {
        return dao.getAll();
    }

    @Override
    public void add(ConsumerOrder order)
    {
        dao.add(order);
    }
}
