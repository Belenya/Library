package library.service;

import library.models.Book;
import library.models.User;
import library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements AbstractService<Book> {

    private BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Book> findAll() {
        return (List<Book>) repository.findAll();
    }

    @Override
    public Book findById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Book book) {
        repository.save(book);
    }

    @Override
    public void delete(Book book) {
        repository.delete(book);
    }

    @Override
    public void update(Book book) {
        repository.updateBook(book.getName(), book.getAuthor(), book.getYear(), book.getId());
    }
}
