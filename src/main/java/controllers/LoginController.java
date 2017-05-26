package controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController
{
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(required = false) String error, @RequestParam(required = false) String logout, Model model)
    {
        if (error != null)
        {
            model.addAttribute("error", "Invalid credentials.");
            model.addAttribute("message", "Try again");
            return "login";
        }

        if (logout != null)
        {
            model.addAttribute("msg", "Logged out.");
            model.addAttribute("message", "Log in");
            return "login";
        }

        model.addAttribute("message", "Log in");
        return "login";
    }
}
