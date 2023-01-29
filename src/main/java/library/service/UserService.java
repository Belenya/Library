package library.service;

import library.models.Book;
import library.models.User;
import library.repositories.BookRepository;
import library.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements AbstractService<User> {

    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }


    public List<User> findAll() {
        return (List<User>)repository.findAll();
    }

    @Override
    public User findById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public void delete(User user) {
        repository.delete(user);
    }

    @Override
    public void update(User user) {
        repository.updateUser(user.getFullName(), user.getYearOfBirth(), user.getId());
    }
}
