package com.applycation.APPLYcation.service;

import com.applycation.APPLYcation.model.exception.LessonNotFoundException;
import com.applycation.APPLYcation.model.Database;
import com.applycation.APPLYcation.model.Lesson;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class LessonService {
    private static final String JSON_FILE_PATH = "src/main/resources/db.json";
    private List<Lesson> lessons;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public LessonService() {
        loadDatabase();
    }

    private void loadDatabase() {
        try {
            Database database = objectMapper.readValue(new File(JSON_FILE_PATH), Database.class);
            this.lessons = database.getLessons();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Lesson> getAllLessons() {
        return lessons;
    }

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
        saveDatabase();
    }

    public Lesson getLessonById(Long id) {
        return lessons.stream()
                .filter(l -> l.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new LessonNotFoundException(id));
    }

    private void saveDatabase() {
        try {
            Database database = new Database();
            database.setLessons(lessons);
            objectMapper.writeValue(new File(JSON_FILE_PATH), database);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
