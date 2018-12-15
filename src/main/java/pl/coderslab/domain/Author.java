package pl.coderslab.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @ManyToMany(mappedBy = "authors",
            cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<>();

    @PESEL
    private String pesel;

    @Email
    private String email;

    public Author() {
    }

    public Author(String name, String surname, Set<Book> books, String pesel, String email) {
        this.name = name;
        this.surname = surname;
        this.books = books;
        this.pesel = pesel;
        this.email = email;
    }

    public void addBooks(Book book){
        this.books.add(book);
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
