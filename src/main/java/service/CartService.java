package service;

import model.Cart;

public interface CartService
{
    void add(Cart cart);

    Cart getCartById (int id);

}
