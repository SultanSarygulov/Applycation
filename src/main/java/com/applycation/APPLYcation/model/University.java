package com.applycation.APPLYcation.model;

import java.util.List;

public class University {
    private Long id;
    private String name;
    private String city;
    private String country;
    private String description;
    private Integer contract;
    private Long roadmapId;

    public University() {}

    public University(Long id, String name, String city, String country, String description, Integer contract, Long roadmapId) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.country = country;
        this.description = description;
        this.contract = contract;
        this.roadmapId = roadmapId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getContract() { return contract; }
    public void setContract(Integer contract) { this.contract = contract; }

    public Long getRoadmapId() { return roadmapId; }
    public void setRoadmapId(Long roadmapId) { this.roadmapId = roadmapId; }
}
