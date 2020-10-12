package main.controller;


import lombok.RequiredArgsConstructor;
import main.dto.project.Project;
import main.service.impl.ProjectServiceImplementation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static main.util.PageUri.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(PROJECT)
public class ProjectController {

    private final ProjectServiceImplementation projectServiceImplementation;


    @GetMapping(ALL)
    public ResponseEntity<List<Project>> getAllProjects() {
        return projectServiceImplementation.getAllProjects();
    }

}
