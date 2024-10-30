package com.applycation.APPLYcation.model;

import java.util.List;

public class Roadmap {

    private Long id;
    private String name;
    private List<Long> lessonsList;

    public Roadmap() {}

    public Roadmap(Long id, String name, List<Long> lessonsList) {
        this.id = id;
        this.name = name;
        this.lessonsList = lessonsList;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Long> getLessonsList() { return lessonsList; }
    public void setLessonsList(List<Long> lessonsList) { this.lessonsList = lessonsList; }
}

