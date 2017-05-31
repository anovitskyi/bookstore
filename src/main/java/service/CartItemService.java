package service;

import model.Cart;
import model.CartItem;

public interface CartItemService
{
    CartItem getById(int id);
    void add(CartItem item);
    void delete(CartItem item);
    void removeAll(Cart cart);

    CartItem findByBookId(int id);
}
