package com.applycation.APPLYcation.service;

import com.applycation.APPLYcation.model.Roadmap;
import com.applycation.APPLYcation.model.Database;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoadmapService {
    private static final String JSON_FILE_PATH = "src/main/resources/db.json";
    private List<Roadmap> roadmaps = new ArrayList<>();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public RoadmapService() {
        loadRoadmaps();
    }

    private void loadRoadmaps() {
        try {
            roadmaps = objectMapper.readValue(new File(JSON_FILE_PATH), new TypeReference<Database>() {}).getRoadmaps();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Roadmap> getAllRoadmaps() {
        return roadmaps;
    }

    public Roadmap getRoadmapById(Long id) {
        return roadmaps.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Roadmap not found with ID: " + id));
    }
}
