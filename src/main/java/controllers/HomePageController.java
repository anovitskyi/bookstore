package controllers;

import model.Book;
import model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.CommonService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomePageController
{
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage()
    {
        return "home";
    }


    @RequestMapping("/about")
    public String about()
    {
        return "about";
    }

    @RequestMapping("/contact")
    public String contact()
    {
        return "contact";
    }

    @RequestMapping("/admin")
    public String redirectToAdmin()
    {
        return "redirect:/admin/";
    }

    @RequestMapping("/books")
    public String redirectToBooks()
    {
        return "redirect:/books/";
    }
}
