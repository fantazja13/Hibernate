package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.domain.*;
import pl.coderslab.repository.AuthorDao;
import pl.coderslab.repository.BookDao;
import pl.coderslab.repository.PersonDao;
import pl.coderslab.repository.PublisherDao;

import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Controller
@RequestMapping(path="/book")
public class BookController {

    @Autowired
    BookDao bookDao;
    @Autowired
    PublisherDao publisherDao;
    @Autowired
    AuthorDao authorDao;
    @Autowired
    PersonDao personDao;
    @Autowired
    Validator validator;

//    @GetMapping(path = "/add", produces = "text/html")
//    public String addBook() {
//        Random random = new Random();
//        Book book = new Book("ADS", "ADADSADS", "ADSADAD","adsdasadsdasads",13);
//        bookDao.saveBook(book);
//        return "Dodano randomową książkę (id: "+book.getId()+")";
//    }

    @GetMapping(path = "/update/{id:\\d+}", produces = "text/html")
    public String updateBook(@PathVariable("id") long id) {
        Book book = bookDao.findBook(id);
        //book.setAuthor("ADSADSjjDASkjASkjadsjkad");
        book.setDescription("11a21das13d11s1f13fds442345132323");
        book.setTitle("123i13jhdsfhj34892");
        bookDao.updateBook(book);
        return "Allahu akbar książka zaktualizowana";
    }

    @GetMapping("/addbooktopublisher")
    public String addBooksToPublisher() {
        Publisher publisher = new Publisher("Publisher name1");

        Book book1 = new Book("book1");
        Book book2 = new Book("book2");
        Book book3 = new Book("book3");

        publisher.addBook(book1);
        publisher.addBook(book2);
        publisher.addBook(book3);

        publisherDao.savePublisher(publisher);

        return "books added";
    }

    @GetMapping("/addauthor")
    public String addAuthorTooBook() {
        Author author = new Author();
        author.setName("imie");
        author.setSurname("nazwisko");

        Book book11 = new Book("book11");
        Book book22 = new Book("book22");
        author.addBooks(book11);
        author.addBooks(book22);

        authorDao.saveAuthor(author);

        return "allahu akbar";
    }

    @GetMapping("/showperson")
    public String showPersonForm(Model model){

        Person person = new Person("Imię", "Nazwisko");
        model.addAttribute("person", person);
        return "home";
    }

    @PostMapping("/showperson")
    @ResponseBody
    public String savePersonToDB(@ModelAttribute Person person){
        personDao.savePerson(person);
        return person.toString();
    }

    @GetMapping("/dodaj")
    public String addBook(Model model) {
        model.addAttribute(new Book());
        return "book";
    }

    @PostMapping("/dodaj")
    public String bookAdded(@Valid @ModelAttribute Book book, BindingResult result) {
        if(result.hasErrors()) {
            return "book";
        }
        bookDao.saveBook(book);
        return "book-added";
    }

    @ModelAttribute("publishers")
    public List<Publisher> publishers() {
        return publisherDao.returnAllPublishers();
    }

}
