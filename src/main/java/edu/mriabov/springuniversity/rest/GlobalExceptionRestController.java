package edu.mriabov.springuniversity.rest;

import edu.mriabov.springuniversity.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice(annotations = RestController.class)
@Order(1)
public class GlobalExceptionRestController extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                 HttpStatus status, WebRequest request){
        return new ResponseEntity<>(new Response(status.toString(),ex.getBindingResult().toString()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<Response> exceptionHandler(Exception exception) {
        return new ResponseEntity<>(new Response("500", exception.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
