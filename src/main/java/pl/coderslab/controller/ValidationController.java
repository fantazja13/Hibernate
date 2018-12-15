package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.domain.Author;
import pl.coderslab.domain.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
@RequestMapping("/validate")
public class ValidationController {

    @Autowired
    Validator validator;

    @GetMapping("/book")
    @ResponseBody
    public String checkValidator() {
        Book book = new Book();
//        book.setTitle("ALaa");
        String result = "";
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Book> constraintViolation : violations) {
                System.out.println(constraintViolation.getPropertyPath() + " "
                        + constraintViolation.getMessage());
                result = "invalid";
            }
        } else {
            result = "object is valid";
        }
        return result;
    }

    @GetMapping("author")
    @ResponseBody
    public String checkAuthor() {
        Author author1 = new Author();
        Author author2 = new Author();

        author1.setPesel("91032214314");
        author2.setPesel("1234567890");

        author1.setEmail("123456.abcd.pl@");
        author2.setEmail("ruskakrowa.123456789@rosja.rosja.RUSSIA.ru");

        Set<ConstraintViolation<Author>> violations1 = validator.validate(author1);
        Set<ConstraintViolation<Author>> violations2 = validator.validate(author2);

        for (ConstraintViolation<Author> violation: violations1) {
            System.out.println(violation.getPropertyPath() +"1 : "+ violation.getMessage());
        }
        for (ConstraintViolation<Author> violation : violations2) {
            System.out.println(violation.getPropertyPath() +"2 : "+ violation.getMessage());

        }
        return "konsola";
    }

}
