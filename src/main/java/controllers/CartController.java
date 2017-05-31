package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Consumer;
import service.ConsumerService;

@Controller
@RequestMapping("/consumer")
public class CartController
{
    @Autowired
    private ConsumerService service;


    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String getCart(@AuthenticationPrincipal org.springframework.security.core.userdetails.User activeUser, Model model)
    {
        Consumer consumer = service.getByUsername(activeUser.getUsername());
        int id = consumer.getCart().getId();
        model.addAttribute("cartId", id);
        return "cart";
    }
}
