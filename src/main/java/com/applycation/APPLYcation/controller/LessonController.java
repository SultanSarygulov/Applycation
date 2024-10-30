package com.applycation.APPLYcation.controller;

import com.applycation.APPLYcation.model.exception.LessonNotFoundException;
import com.applycation.APPLYcation.model.Lesson;
import com.applycation.APPLYcation.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {

    private final LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping
    public List<Lesson> getAllLessons() {
        return lessonService.getAllLessons();
    }

    @GetMapping("/{id}")
    public Lesson getLessonById(@PathVariable Long id) {
        return lessonService.getLessonById(id);
    }

    @PostMapping
    public void addLesson(@RequestBody Lesson lesson) {
        lessonService.addLesson(lesson);
    }

    // Exception Handler for LessonNotFoundException
    @ExceptionHandler(LessonNotFoundException.class)
    public ResponseEntity<String> handleLessonNotFound(LessonNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
