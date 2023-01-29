package library.repositories;

import library.models.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Iterable<User> findAll();
    Optional<User> findById(Long id);

    @Modifying
    @Transactional
    @Query("update User u set u.fullName =?1, u.yearOfBirth = ?2 where u.id = ?3")
    void updateUser(String fullName, Integer age, Long id);
}
