package com.labforward.task.exception;

public class MoreThanOneOfSameAttributeException extends RuntimeException {

    public MoreThanOneOfSameAttributeException() {
        super("Some attributes are given more than once as input.");
    }
}
