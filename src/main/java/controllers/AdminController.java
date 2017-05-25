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
import org.springframework.web.multipart.MultipartFile;
import service.CommonService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

@Controller
@RequestMapping("/admin")
public class AdminController
{
    @Autowired
    private CommonService<Book> service;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String adminPage(Model model)
    {
        model.addAttribute("list", service.getAll());
        return "admin";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addForm(Model model)
    {
        model.addAttribute("genres", Arrays.asList(Genre.values()));
        model.addAttribute(new Book());
        return "add";
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public String add(@Valid Book book, BindingResult result, Model model, HttpServletRequest request) throws IOException
    {
        if (result.hasErrors())
        {
            model.addAttribute(book);
            return "add";
        }
        service.add(book);

        MultipartFile img = book.getImg();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        String path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\books\\" + book.getId() + ".png").toString();
        if (img != null && !img.isEmpty())
        {
            img.transferTo(new java.io.File(path));
        }

        return "redirect:/admin/";
    }

    @RequestMapping(value = "/books/update/{id}", method = RequestMethod.GET)
    public String updateGet(@PathVariable int id, Model model)
    {
        Book book = service.get(id);
        if (book == null || book.getUnitsInStock() < 1)
        {
            model.addAttribute("message", "There is no available books. Sorry :(");
            return "redirection";
        }
        model.addAttribute("genres", Arrays.asList(Genre.values()));
        model.addAttribute("book", book);
        return "update";
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.POST)
    public String update(@PathVariable int id, @Valid Book book, BindingResult result, Model model)
    {
        if (result.hasErrors())
        {
            model.addAttribute(book);
            return "update";
        }
        Book book1 = service.get(id);
        book1.setAutor(book.getAutor());
        book1.setName(book.getName());
        book1.setDesc(book.getDesc());
        book1.setUnitsInStock(book.getUnitsInStock());
        book1.setImg(book.getImg());
        book1.setGenre(book.getGenre());
        book1.setPrice(book.getPrice());

        service.update(book1);

        return "redirect:/admin/";
    }


    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id, Model model)
    {
        Book book = service.get(id);
        if (book == null || book.getUnitsInStock() < 1)
        {
            model.addAttribute("message", "There is no available books. Sorry :(");
            return "redirection";
        }
        service.delete(book);
        return "redirect:/admin/";
    }
}