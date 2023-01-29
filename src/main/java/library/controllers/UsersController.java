package library.controllers;

import library.models.User;
import library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("users")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String users(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users/users";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "users/show";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping
    public String createUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("{id}/edit")
    public String updateUser(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.findById(id));
        return "users/edit";
    }

    @PatchMapping("{id}")
    public String update(@ModelAttribute("user") User user, BindingResult bindingResult, @PathVariable("id") long id) {
//        if (bindingResult.hasErrors()) {
//            return "users/edit";
//        }
        userService.update(user);
        return "redirect:/users";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") long id) {
        User user = new User();
        user.setId(id);
        userService.delete(user);
        return "redirect:/users";
    }
}
