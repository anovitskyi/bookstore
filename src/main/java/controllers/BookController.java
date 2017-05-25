package controllers;

import model.Book;
import model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.CommonService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/books")
public class BookController
{

    @Autowired
    private CommonService<Book> service;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showBooks(Model model)
    {
        List<Book> list = service.getAll();
        if (list.isEmpty())
        {
            model.addAttribute("message", "There is no available books. Sorry :(");
            return "redirection";
        }
        else
        {
            model.addAttribute("list", list);
            model.addAttribute("helloMessage", "This is what we can offer:");
            return "books";
        }
    }

    @RequestMapping(value = "/genres/{g}", method = RequestMethod.GET)
    public String showByGenres(@PathVariable String g, Model model)
    {
        List<Book> list = service.getAll();
        List<Book> result = new ArrayList<>();
        for (Book book : list)
        {
            if (book.getGenre().toString().intern() == g.intern())
                result.add(book);
        }

        if (list.isEmpty() || result.isEmpty())
        {
            model.addAttribute("message", "There is no books that match your expectations. Sorry :(");
            return "redirection";
        }
        else
        {
            model.addAttribute("list", result);
            model.addAttribute("helloMessage", "What we found for your request: " + g);
            return "books";
        }
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String buy(@PathVariable int id, Model model)
    {
        Book book = service.get(id);
        if (book == null || book.getUnitsInStock() < 1)
        {
            model.addAttribute("message", "There is no available books. Sorry :(");
            return "redirection";
        }
        model.addAttribute(book);
        return "buy";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String makePurchase(@PathVariable int id, Model model)
    {
       throw new UnsupportedOperationException("NOT IMPLEMENTED METHOD");
    }
}
