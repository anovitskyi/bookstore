package dao.impl;


import dao.CartDao;
import model.Cart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Repository
@Transactional
public class CartDaoImpl implements CartDao
{
    @Autowired
    private SessionFactory session;

    @Override
    public void add(Cart cart)
    {
        session.getCurrentSession().saveOrUpdate(cart);
    }

    @Override
    public Cart getCartById(int id)
    {
        return (Cart) session.getCurrentSession().get(Cart.class, id);
    }

    @Override
    public void update(Cart cart)
    {
        /*int cartId = cart.getId();
        double grandTotal = customerOrderService.getCustomerOrderGrandTotal(cartId);
        cart.setGrandTotal(grandTotal);

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cart);*/
    }
}
