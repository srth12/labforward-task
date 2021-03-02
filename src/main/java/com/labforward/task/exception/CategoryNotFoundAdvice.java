package com.labforward.task.exception;

import com.labforward.task.dto.ResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CategoryNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(CategoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ResponseEntity<ResponseObject> categoryNotFoundHandler(CategoryNotFoundException ex) {
        return new ResponseEntity<>(new ResponseObject(ex.getMessage(),500),HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @ExceptionHandler(ItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ResponseEntity<ResponseObject> itemNotFoundHandler(ItemNotFoundException ex) {
        return new ResponseEntity<>(new ResponseObject(ex.getMessage(),500),HttpStatus.NOT_FOUND);
    }

    @ResponseBody
    @ExceptionHandler(AttributeDoesNotBelongToCategoryException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ResponseEntity<ResponseObject> attributeDoesNotBelongToCategoryHandler(AttributeDoesNotBelongToCategoryException ex) {
        return new ResponseEntity<>(new ResponseObject(ex.getMessage(),400),HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @ExceptionHandler(MoreThanOneOfSameAttributeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ResponseEntity<ResponseObject> moreThanOneOfSameAttributeHandler(MoreThanOneOfSameAttributeException ex) {
        return new ResponseEntity<>(new ResponseObject(ex.getMessage(),400),HttpStatus.BAD_REQUEST);
    }
}
