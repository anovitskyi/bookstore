package service.impl;


import dao.*;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import service.ConsumerService;

import java.util.List;

@Service
public class ConsumerServiceImpl implements ConsumerService
{
    @Autowired
    private ConsumerDao dao;

    @Autowired
    private AdressDao adressDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private AuthorityDao authorityDao;

    @Autowired
    private CartDao cartDao;

    @Autowired
    private BCryptPasswordEncoder encoder;


    @Override
    public Consumer getByEmail(String email)
    {
        return dao.getByEmail(email);
    }

    @Override
    public void add(Consumer consumer)
    {
        consumer.setPassword(encoder.encode(consumer.getPassword()));
        Adress adress = adressDao.get(consumer.getAdress());

        if (adress != null)
            consumer.setAdress(adress);


        dao.add(consumer);

        User user = new User(consumer.getUsername(), consumer.getPassword(), consumer.isEnabled(), consumer.getId());
        Authority authority = new Authority(consumer.getUsername(), Role.ROLE_USER);

        userDao.addUser(user);
        authorityDao.addAuthority(authority);

        Cart cart = new Cart();
        cart.setConsumer(consumer);
        cartDao.add(cart);


        consumer.setCart(cart);
        dao.add(consumer);

    }

    @Override
    public Consumer getById(int id)
    {
        return dao.getById(id);
    }

    @Override
    public List<Consumer> getAll()
    {
        return dao.getAll();
    }

    @Override
    public Consumer getByUsername(String username)
    {
        return dao.getByUsername(username);
    }
}
