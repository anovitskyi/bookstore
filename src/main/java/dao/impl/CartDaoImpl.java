package dao.impl;


import dao.CartDao;
import model.Cart;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

}
