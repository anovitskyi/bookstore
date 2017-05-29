package service.impl;


import dao.ConsumerDao;
import model.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ConsumerService;

import java.util.List;

@Service
public class ConsumerServiceImpl implements ConsumerService
{
    @Autowired
    private ConsumerDao dao;

    @Override
    public Consumer getByEmail(String email)
    {
        return dao.getByEmail(email);
    }

    @Override
    public void add(Consumer consumer)
    {
        dao.add(consumer);
    }
}
