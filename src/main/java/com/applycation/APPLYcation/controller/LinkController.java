package com.applycation.APPLYcation.controller;

import com.applycation.APPLYcation.model.Link;
import com.applycation.APPLYcation.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/links")
public class LinkController {

    @Autowired
    private LinkService linkService;

    @GetMapping
    public List<Link> getAllLinks() {
        return linkService.getAllLinks();
    }

    @PostMapping
    public Link addLink(@RequestBody Link link) {
        linkService.addLink(link);
        return link;
    }
}