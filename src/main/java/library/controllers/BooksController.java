package library.controllers;

import library.models.Book;
import library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("books")
public class BooksController {

    private final BookService bookService;

    @Autowired
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String books(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books/books";
    }

    @GetMapping("/{id}")
    public String showBook(@PathVariable("id") long id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "books/show";
    }

    @GetMapping("/new")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
        return "books/new";
    }

    @PostMapping
    public String createBook(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("{id}/edit")
    public String updateBook(Model model, @PathVariable("id") long id) {
        model.addAttribute("book", bookService.findById(id));
        return "books/edit";
    }

    @PatchMapping("{id}")
    public String update(@ModelAttribute("user") Book book, BindingResult bindingResult, @PathVariable("id") long id) {
//        if (bindingResult.hasErrors()) {
//            return "users/edit";
//        }
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
