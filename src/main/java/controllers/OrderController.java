package controllers;

import model.Cart;
import model.CartItem;
import model.Consumer;
import model.ConsumerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.CartItemService;
import service.CartService;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String makeOrder(@AuthenticationPrincipal User user, Model model)
    {
        Consumer consumer = consumerService.getByUsername(user.getUsername());
        Cart cart = consumer.getCart();
        if (cart.getList() == null)
        {
            model.addAttribute("message", "Your cart is empty :(");
            return "redirection";
        }
        double price = 0;
        for (CartItem item : cart.getList())
            price += item.getTotalPrice();
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
            price += item.getTotalPrice();
        ConsumerOrder order = new ConsumerOrder(cart, consumer, new java.util.Date(), price);


        orderService.add(order);

        cartItemService.removeAll(cart);

        model.addAttribute("message", "Thank you for making order :)");
        return "redirection";
    }
}
