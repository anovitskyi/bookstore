package service;

import model.Cart;

import java.io.IOException;

public interface CartService
{
    void add(Cart cart);

    Cart getCartById (int id);

    void update(Cart cart);
}
