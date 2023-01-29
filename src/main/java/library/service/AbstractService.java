package library.service;

import library.models.User;
import library.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AbstractService<T> {

    List<T> findAll();

    T findById(long id);

    void save(T obj);

    void delete(T obj);

    void update(T obj);
}
