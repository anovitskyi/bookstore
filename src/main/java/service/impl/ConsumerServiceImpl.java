package service.impl;


import dao.CommonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Consumer;
import service.CommonService;

import java.util.List;

@Service
public class ConsumerServiceImpl implements CommonService<Consumer>
{
    @Autowired
    private CommonDao<Consumer> dao;

    @Override
    public List<Consumer> getAll()
    {
        return dao.getAll();
    }

    @Override
    public Consumer get(int id)
    {
        return dao.get(id);
    }

    @Override
    public void add(Consumer param)
    {
        dao.add(param);
    }

    @Override
    public void update(Consumer param)
    {
        dao.update(param);
    }

    @Override
    public void delete(Consumer param)
    {
        dao.delete(param);
    }
}
