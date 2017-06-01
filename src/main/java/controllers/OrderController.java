package controllers;

import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.BookService;
import service.CartItemService;
import service.ConsumerService;
import service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController
{
    @Autowired
    private OrderService orderService;

    @Autowired
    private ConsumerService consumerService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String makeOrder(@AuthenticationPrincipal User user, Model model)
    {
        Consumer consumer = consumerService.getByUsername(user.getUsername());
        Cart cart = consumer.getCart();
        if (cart.getList() == null || cart.getList().isEmpty())
        {
            model.addAttribute("message", "Your cart is empty :(");
            return "redirection";
        }
        double price = 0;
        for (CartItem item : cart.getList())
        {
            if (item.getQuantity() > item.getBook().getUnitsInStock())
            {
                model.addAttribute("error", "There is not enough books to submit your order :(");
                model.addAttribute("cartId", cart.getId());
                return "cart";
            }
            price += item.getTotalPrice();
        }
        ConsumerOrder order = new ConsumerOrder(cart, consumer, new java.util.Date(), price);

        model.addAttribute("order", order);

        return "order";
    }

    @RequestMapping(value = "/done", method = RequestMethod.POST)
    public String madePurchase(@AuthenticationPrincipal User user, Model model)
    {
        Consumer consumer = consumerService.getByUsername(user.getUsername());
        Cart cart = consumer.getCart();
        double price = 0;
        for (CartItem item : cart.getList())
        {
            Book book = item.getBook();

            book.setUnitsInStock(book.getUnitsInStock() - item.getQuantity());

            bookService.update(book);
            price += item.getTotalPrice();
        }
        ConsumerOrder order = new ConsumerOrder(cart, consumer, new java.util.Date(), price);

        orderService.add(order);

        cartItemService.removeAll(cart);

        model.addAttribute("message", "Thank you for making order :)");
        return "redirection";
    }
}
