package dao;

import model.Cart;
import model.CartItem;

public interface CartItemDao
{
    CartItem getById(int id);
    void add(CartItem item);
    void delete(CartItem item);
    void removeAll(Cart cart);

    CartItem findByBookId(int id);

}
