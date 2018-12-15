package pl.coderslab.domain;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;


public class DateValidator implements ConstraintValidator<CheckDate, String> {

    @Override
    public void initialize(CheckDate checkDate) {

    }

    @Override
    public boolean isValid(String strDate, ConstraintValidatorContext constraintValidatorContext) {
        LocalDateTime date;
        try {
            date = LocalDateTime.parse(strDate);
            boolean temp = date.compareTo(LocalDateTime.now())<0;
            System.out.println(temp);
            return temp;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
