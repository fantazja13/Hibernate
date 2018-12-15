package pl.coderslab.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.Constraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 20, message = "ZŁY ROZMIAR ADNOTACJA")
    private String title;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Publisher publisher;

    @Column(length=200)
    @NotBlank(message = "Nie może być puste")
    private String description;

    private Integer rating;

    @Transient
    @CheckDate(message = "zła data")
    private String strPublishDate;

    private LocalDateTime publishDate;

    public Book() { }

    public Book(String title){
        this.title = title;
    }

    public Book(String title, Set<Author> authors, Publisher publisher, String description, Integer rating, Integer pesel, String email, LocalDateTime publishDate, String strPublishDate) {
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.description = description;
        this.rating = rating;
        this.publishDate = publishDate;
        this.strPublishDate = strPublishDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
    }

    public String getStrPublishDate() {
        return strPublishDate;
    }

    public void setStrPublishDate(String strPublishDate) {
        this.strPublishDate = strPublishDate;
    }


}