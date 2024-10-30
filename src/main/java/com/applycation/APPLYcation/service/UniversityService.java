package com.applycation.APPLYcation.service;

import com.applycation.APPLYcation.model.Database;
import com.applycation.APPLYcation.model.University;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UniversityService {
    private static final String JSON_FILE_PATH = "src/main/resources/db.json";
    private List<University> universities = new ArrayList<>();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public UniversityService() {
        loadUniversities();
    }

    private void loadUniversities() {
        try {
            universities = objectMapper.readValue(new File(JSON_FILE_PATH), new TypeReference<Database>() {}).getUniversities();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<University> getAllUniversities() {
        return universities;
    }

    public University getUniversityById(Long id) {
        return universities.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("University not found with ID: " + id));
    }
}
