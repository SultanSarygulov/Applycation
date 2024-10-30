package com.applycation.APPLYcation.model;

import java.util.List;

public class Database {
    private List<Lesson> lessons;
    private List<University> universities;
    private List<Roadmap> roadmaps;

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public List<University> getUniversities() {
        return universities;
    }

    public void setUniversities(List<University> universities) {
        this.universities = universities;
    }

    public List<Roadmap> getRoadmaps() {
        return roadmaps;
    }

    public void setRoadmaps(List<Roadmap> roadmaps) {
        this.roadmaps = roadmaps;
    }
}
