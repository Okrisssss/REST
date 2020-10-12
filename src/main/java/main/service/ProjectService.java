package main.service;

import main.dto.project.Project;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectService {

    ResponseEntity<List<Project>> getAllProjects();
}
