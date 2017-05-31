package dao;


import model.Cart;

import java.io.IOException;

public interface CartDao
{
    void add(Cart cart);

    Cart getCartById (int id);

}
