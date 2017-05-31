package service.impl;


import dao.CartItemDao;
import model.Cart;
import model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService
{

    @Autowired
    private CartItemDao dao;

    @Override
    public CartItem getById(int id)
    {
        return dao.getById(id);
    }

    @Override
    public void add(CartItem item)
    {
        dao.add(item);
    }

    @Override
    public void delete(CartItem item)
    {
        dao.delete(item);
    }

    @Override
    public void removeAll(Cart cart)
    {
        dao.removeAll(cart);
    }

    @Override
    public CartItem findByBookId(int id)
    {
        return dao.findByBookId(id);
    }
}
