package library.repositories;

import library.models.Book;
import library.models.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {
    Iterable<Book> findAll();
    Optional<Book> findById(Long id);

    @Modifying
    @Transactional
    @Query("update Book b set b.name =?1, b.author = ?2, b.year = ?3, b.user = ?4 where b.id = ?5")
    void updateBook(String name, String author, Integer year, User user, Long id);
}
