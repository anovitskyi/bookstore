package dao.impl;


import dao.CartItemDao;
import model.Cart;
import model.CartItem;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao
{

    @Autowired
    private SessionFactory session;

    @Override
    public CartItem getById(int id)
    {
        return (CartItem) session.getCurrentSession().get(CartItem.class, id);
    }

    @Override
    public void add(CartItem item)
    {
        session.getCurrentSession().saveOrUpdate(item);
    }

    @Override
    public void delete(CartItem item)
    {
        session.getCurrentSession().delete(item);
    }

    @Override
    public void removeAll(Cart cart)
    {
        for (CartItem item : cart.getList())
            session.getCurrentSession().delete(item);
    }

    @Override
    public CartItem findByBookId(int id)
    {
        return (CartItem) session.getCurrentSession().createQuery("from model.CartItem where book_id = ?")
                .setParameter(0 , id)
                .uniqueResult();
    }
}
