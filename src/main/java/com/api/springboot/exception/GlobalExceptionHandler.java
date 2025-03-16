//package com.api.springboot.exception;
//
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.util.NoSuchElementException;
//
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//    private final Logger logger =  LoggerFactory.getLogger(GlobalExceptionHandler.class);
//
//    @ExceptionHandler(IllegalArgumentException.class)
//    public ResponseEntity<String> handleBusinessException(IllegalArgumentException businessException){
//        return new ResponseEntity<>(businessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
//    }
//
//    @ExceptionHandler(NoSuchElementException.class)
//    public ResponseEntity<String> handleNotFoundException(NoSuchElementException businessException){
//        return new ResponseEntity<>(businessException.getMessage(), HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handleUnexpectedException(Exception exception) {
//        if (exception.getClass().getName().startsWith("org.springdoc")) {
//            return ResponseEntity.internalServerError().build(); // Deixa o Swagger tratar isso
//        }
//
//        logger.error("Erro inesperado: ", exception);
//        return new ResponseEntity<>("Erro interno de servidor", HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//}
//
