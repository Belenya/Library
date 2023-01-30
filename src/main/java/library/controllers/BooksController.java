package library.controllers;

import library.models.Book;
import library.models.User;
import library.service.BookService;
import library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("books")
public class BooksController {

    private final BookService bookService;
    private final UserService userService;

    @Autowired
    public BooksController(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping
    public String books(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books/books";
    }

    @GetMapping("/{id}")
    public String showBook(@PathVariable("id") long id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        model.addAttribute("users", userService.findAll());
        model.addAttribute("emptyUser", new User());
        return "books/show";
    }

    @GetMapping("/new")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
        return "books/new";
    }

    @PostMapping
    public String createBook(@ModelAttribute @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "books/edit";
        }
        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("{id}/edit")
    public String updateBook(Model model, @PathVariable("id") long id) {
        model.addAttribute("book", bookService.findById(id));
        return "books/edit";
    }

    @PatchMapping("{id}")
    public String update(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "books/edit";
        }
        bookService.update(book);
        return "redirect:/books";
    }

    @PatchMapping("{id}/set")
    public String setUser(@ModelAttribute("emptyUser") User user, @PathVariable("id") long id) {
        Book book = bookService.findById(id);
        book.setUser(userService.findById(user.getId()));
        bookService.update(book);
        return "redirect:/books";
    }

    @PatchMapping("{id}/free")
    public String freeBook(@PathVariable("id") long id) {
        Book book = bookService.findById(id);
        book.setUser(null);
        bookService.update(book);
        return "redirect:/books";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") long id) {
        Book book = new Book();
        book.setId(id);
        bookService.delete(book);
        return "redirect:/books";
    }
}
