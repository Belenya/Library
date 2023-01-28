package library.models;

public class User {

    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private Short yearOfBirth;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Short getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Short yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
}
