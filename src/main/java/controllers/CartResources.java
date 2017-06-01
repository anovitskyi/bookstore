package controllers;

import model.Book;
import model.Cart;
import model.CartItem;
import model.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.BookService;
import service.CartItemService;
import service.CartService;
import service.ConsumerService;

import java.util.List;

@Controller
@RequestMapping("/rest/cart")
public class CartResources
{

    @Autowired
    private CartService cartService;

    @Autowired
    private ConsumerService consumerService;

    @Autowired
    private BookService bookService;

    @Autowired
    private CartItemService cartItemService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Cart getCartById(@PathVariable int id)
    {
        return cartService.getCartById(id);
    }

    @RequestMapping(value = "/add/{bookId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addBook(@PathVariable int bookId, @AuthenticationPrincipal User activeUser)
    {
        Consumer consumer = consumerService.getByUsername(activeUser.getUsername());
        Cart cart = consumer.getCart();
        Book book = bookService.get(bookId);
        List<CartItem> list = cart.getList();
        for (CartItem item : list)
        {
            if (item.getBook().getId().compareTo(book.getId()) == 0)
            {
                item.setQuantity(item.getQuantity() + 1);
                item.setTotalPrice(item.getTotalPrice() + book.getPrice());
                cartItemService.add(item);
                return;
            }
        }
        CartItem item = new CartItem(book, 1, book.getPrice(), cart);
        cartItemService.add(item);
    }

    @RequestMapping(value = "/delete/{bookId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable int bookId)
    {
        CartItem item = cartItemService.findByBookId(bookId);
        cartItemService.delete(item);

    }


    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload.")
    public void handleClientErrors (Exception e) {}

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error.")
    public void handleServerErrors (Exception e) {}
}
