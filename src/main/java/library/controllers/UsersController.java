package library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("users")
public class UsersController {

    @GetMapping
    public String books(Model model) {
//        model.addAttribute("users", )
        return "users/users";
    }

//    @GetMapping()
//    public String index() {
//        return "index";
//    }
//
//    @GetMapping
//    public String index() {
//        return "index";
//    }
//
//    @GetMapping
//    public String index() {
//        return "index";
//    }
}
