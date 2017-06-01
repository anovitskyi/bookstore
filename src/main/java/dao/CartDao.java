package dao;


import model.Cart;

public interface CartDao
{
    void add(Cart cart);

    Cart getCartById (int id);

}
