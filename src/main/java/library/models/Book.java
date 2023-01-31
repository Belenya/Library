package library.models;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Название не может быть пустым.")
    @Size(min = 2, max = 100, message = "Допустимая длинна от 2 до 100 символов.")
    private String name;

    @NotEmpty(message = "Автор не может мыть пустым.")
    @Size(min = 2, max = 100, message = "Допустимая длинна от 2 до 100 символов.")
    private String author;

    @Min(value = 1500, message = "Минимальный год 1500.")
    private Integer year;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

}
