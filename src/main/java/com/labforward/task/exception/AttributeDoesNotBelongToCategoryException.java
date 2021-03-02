package com.labforward.task.exception;

public class AttributeDoesNotBelongToCategoryException extends RuntimeException{

    public AttributeDoesNotBelongToCategoryException(Long id) {
        super("Input attributes does not belong to the given category with id " + id);
    }
}
