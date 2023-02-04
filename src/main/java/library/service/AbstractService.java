package library.service;



import java.util.List;

public interface AbstractService<T, ID> {

    List<T> findAll();

    T findById(ID id);

    void save(T obj);

    void delete(ID id);

    void update(T obj);
}
