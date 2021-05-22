package ua.com.alevel.category.advice;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ua.com.alevel.category.exeption.CustomException;

@ControllerAdvice
public class CategoryControllerAdvice {

    @ExceptionHandler(value = CustomException.class)
    ResponseEntity<String> categoryNotFountResponse(){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
