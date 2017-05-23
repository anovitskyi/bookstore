package controllers;

import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.CommonService;

import java.util.List;

@Controller
public class HomePageController
{
    @Autowired
    private CommonService<Book> service;

    private String emptyList = "There is no available books. Sorry :("

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage()
    {
        return "home";
    }

    @RequestMapping(value = "/display", method = RequestMethod.GET)
    public String showBooks(Model model)
    {
        List<Book> list = service.getAll();
        if (list.isEmpty())
            model.addAttribute("errorMessage", emptyList);
        else
            model.addAttribute("list", list);

        return "display";
    }
}
