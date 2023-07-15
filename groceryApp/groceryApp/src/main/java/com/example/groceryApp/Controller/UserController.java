package com.example.groceryApp.Controller;

import com.example.groceryApp.Model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private userRepository userRepository;

    @RequestMapping("/")
    public String home(){
        return "index";
    }
    @GetMapping("/index")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new user());
        return "index";
    }

    @PostMapping("/index")
    public String registerUser(@ModelAttribute("user") @Valid user user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }

        //Perform user registration logic
        userRepository.save(user);

        return "redirect:/login";
    }
}




