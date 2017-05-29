package controllers;


import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import model.Consumer;
import service.ConsumerService;

@Controller
public class LoginController
{
    @Autowired
    private ConsumerService consumerService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(required = false) String error, Model model, HttpServletRequest request)
    {
        if (request.getRemoteUser() != null)
        {
            return "redirect:/";
        }
        if (error != null)
        {
            model.addAttribute("error", "Invalid credentials");
            model.addAttribute("message", "Try again");
            return "login";
        }

        model.addAttribute("message", "Welcome");
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, Model model)
    {
        if (request.getRemoteUser() == null)
            return "redirect:/";
        else
            return "redirect:/j_spring_security_logout";
    }

    @RequestMapping(value = "/singup", method = RequestMethod.GET)
    public String singup(Model model, HttpServletRequest request)
    {
        if (request.getRemoteUser() != null)
            return "redirect:/";
        model.addAttribute(new Consumer());
        model.addAttribute("countries", Arrays.asList(Countries.values()));
        return "singup";
    }

    @RequestMapping(value = "/singup", method = RequestMethod.POST)
    public String singup(@Valid Consumer consumer, BindingResult result, @ModelAttribute("pass") String password, Model model)
    {
        if (result.hasErrors())
        {
            model.addAttribute("countries", Arrays.asList(Countries.values()));
            consumer.setPassword("");
            consumer.setUsername("");
            model.addAttribute(consumer);
            return "singup";
        }
        if (!password.equals(consumer.getPassword()))
        {
            model.addAttribute("countries", Arrays.asList(Countries.values()));
            consumer.setPassword("");
            consumer.setUsername("");
            model.addAttribute(consumer);
            result.rejectValue("password", "error.object","Different passwords provided");
            return "singup";
        }
        model.asMap().clear();

        consumer.setEnabled(true);
        consumerService.add(consumer);


        model.addAttribute("message","You have been succssesfully singed up!");
        return "redirection";
    }

    @RequestMapping(value = "/denied", method = RequestMethod.GET)
    public String deniedAccess(Model model)
    {
        model.addAttribute("message", "Access denied");
        return "redirection";
    }
}
