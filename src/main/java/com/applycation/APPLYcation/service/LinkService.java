package com.applycation.APPLYcation.service;

import com.applycation.APPLYcation.model.Link;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class LinkService {
    private static final String JSON_FILE_PATH = "src/main/resources/db.json";
    private List<Link> links = new ArrayList<>();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public LinkService() {
        loadLinks();
    }

    private void loadLinks() {
        try {
            links = objectMapper.readValue(new File(JSON_FILE_PATH), new TypeReference<>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Link> getAllLinks() {
        return links;
    }

    public void addLink(Link link) {
        links.add(link);
        saveLinks();
    }

    private void saveLinks() {
        try {
            objectMapper.writeValue(new File(JSON_FILE_PATH), links);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
