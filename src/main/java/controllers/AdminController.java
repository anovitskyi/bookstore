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
import service.BookService;

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
    private BookService service;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String adminPage(Model model)
    {
        model.addAttribute("list", service.getAll());
        return "admin";
    }

    @RequestMapping(value = "/books/add", method = RequestMethod.GET)
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
        if (book == null)
        {
            model.addAttribute("message", "There is no available books. Sorry :(");
            return "redirection";
        }
        model.addAttribute("genres", Arrays.asList(Genre.values()));
        model.addAttribute("book", book);
        return "update";
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.POST)
    public String update(@PathVariable int id, @Valid Book book, BindingResult result, Model model, HttpServletRequest request) throws IOException
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


        MultipartFile img = book1.getImg();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        String path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\books\\" + book1.getId() + ".png").toString();
        if (img != null && !img.isEmpty())
        {
            java.io.File file = new java.io.File(path);
            if (file.exists())
                file.delete();
            img.transferTo(file);
        }


        service.update(book1);

        return "redirect:/admin/";
    }


    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id, Model model, HttpServletRequest request)
    {
        Book book = service.get(id);
        if (book == null)
        {
            model.addAttribute("message", "There is no available books. Sorry :(");
            return "redirection";
        }
        service.delete(book);
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        String path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\books\\" + book.getId() + ".png").toString();
        java.io.File file = new java.io.File(path);
        if (file.exists())
            file.delete();
        return "redirect:/admin/";
    }
}
