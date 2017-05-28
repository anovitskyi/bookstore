package controllers;

import model.Book;
import model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.CommonService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomePageController
{
    @Autowired
    CommonService<Book> service;

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

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(Model model)
    {
        model.addAttribute("genres", Arrays.asList(Genre.values()));
        model.addAttribute(new Book());
        return "search";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@Valid Book book, BindingResult result, Model model)
    {
        if(book.getName() == null && book.getAutor() == null && book.getGenre() == null)
            return "redirect:/books/";

        List<Book> res = new ArrayList<>();
        List<Book> list = service.getAll();
        for (Book b : list)
        {
            if (book.getName() == null)
            {
                if (book.getAutor() == null)
                {
                    if (b.getGenre().equals(book.getGenre()) || book.getGenre() == null)
                    {
                        res.add(b);
                    }
                }
                else if (b.getAutor().toLowerCase().contains(book.getAutor().toLowerCase()))
                {
                    if (b.getGenre() == book.getGenre() || book.getGenre() == null)
                    {
                        res.add(b);
                    }
                }
            }
            else if (b.getName().toLowerCase().contains(book.getName().toLowerCase()))
            {
                if (book.getAutor() == null)
                {
                    if (b.getGenre().equals(book.getGenre()) || book.getGenre() == null)
                    {
                        res.add(b);
                    }
                }
                else if (b.getAutor().toLowerCase().contains(book.getAutor().toLowerCase()))
                {
                    if (b.getGenre() == book.getGenre() || book.getGenre() == null)
                    {
                        res.add(b);
                    }
                }
            }
        }

        if (res.isEmpty())
        {
            model.addAttribute("message", "There is no books that match your expectations. Sorry :(");
            return "redirection";
        }

        String name = book.getName() != null ? book.getName() : "";
        String author = book.getAutor() != null ? book.getAutor() : "";
        String genre = book.getGenre() != null ?  book.getGenre().toString() : "";
        model.addAttribute("helloMessage", "What we found for your request: " + name + " " + author + " " + genre);
        model.addAttribute("list", res);
        return "books";
    }
}
