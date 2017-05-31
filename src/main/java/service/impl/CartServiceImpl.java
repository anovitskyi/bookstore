package service.impl;


import dao.CartDao;
import model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CartService;

@Service
public class CartServiceImpl implements CartService
{

    @Autowired
    private CartDao cartDao;

    @Override
    public void add(Cart cart)
    {
        cartDao.add(cart);
    }

    @Override
    public Cart getCartById(int id)
    {
        return cartDao.getCartById(id);
    }

    @Override
    public void update(Cart cart)
    {
        cartDao.update(cart);
    }
}
