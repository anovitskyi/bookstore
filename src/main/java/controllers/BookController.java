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
public class BookController
{

    @Autowired
    private CommonService<Book> service;


    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String showBooks(Model model)
    {
        List<Book> list = service.getAll();
        if (list.isEmpty())
        {
            return "notFound";
        }
        else
        {
            model.addAttribute("list", list);
            model.addAttribute("helloMessage", "This is what we can offer:");
            return "books";
        }
    }

    @RequestMapping(value = "/genres", method = RequestMethod.GET)
    public String showBygenres(@RequestParam Genre g, Model model)
    {
        List<Book> list = service.getAll();
        List<Book> result = new ArrayList<>();
        for (Book book : list)
        {
            if (book.getGenre() == g)
                result.add(book);
        }

        if (list.isEmpty())
        {
            return "notFound";
        }
        else
        {
            model.addAttribute("list", result);
            model.addAttribute("helloMessage", "What we found for your request: " + g);
            return "books";
        }
    }
}
