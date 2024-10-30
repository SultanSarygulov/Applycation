package com.applycation.APPLYcation.controller;

import com.applycation.APPLYcation.model.Roadmap;
import com.applycation.APPLYcation.service.RoadmapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roadmaps")
public class RoadmapController {

    @Autowired
    private RoadmapService roadmapService;

    @GetMapping
    public List<Roadmap> getAllRoadmaps() {
        return roadmapService.getAllRoadmaps();
    }

    @GetMapping("/{id}")
    public Roadmap getRoadmapById(@PathVariable Long id) {
        return roadmapService.getRoadmapById(id);
    }
}
