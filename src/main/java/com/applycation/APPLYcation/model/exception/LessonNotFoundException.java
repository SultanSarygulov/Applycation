package com.applycation.APPLYcation.model.exception;

public class LessonNotFoundException extends RuntimeException {
    public LessonNotFoundException(Long id) {
        super("We don’t have such a lesson with ID: " + id);
    }
}
