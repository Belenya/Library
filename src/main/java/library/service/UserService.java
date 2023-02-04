package library.service;

import library.models.Book;
import library.models.User;
import library.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserService {

    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        return (List<User>)repository.findAll();
    }

    public User findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public void save(User user) {
        repository.save(user);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public void update(User user) {
        repository.save(user);
    }
}
