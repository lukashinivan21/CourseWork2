package pro.sky.java.course2.coursework2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AmountIsTooMuchLargeException extends RuntimeException{

    public AmountIsTooMuchLargeException(String message) {
        super(message);
    }
}
