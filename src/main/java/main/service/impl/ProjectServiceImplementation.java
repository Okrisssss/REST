package main.service.impl;

import main.dto.jira.SessionValue;
import main.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

import static main.util.PageUri.GET_ALL_PROJECTS;



@Service
public class ProjectServiceImplementation implements ProjectService {

    @Autowired
    JiraServiceImplementation jiraServiceImplementation;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public ResponseEntity getAllProjects() {
        jiraServiceImplementation.getSession();
        SessionValue sessionValue = jiraServiceImplementation.sessionValue;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("cookie", "JSESSIONID=" + sessionValue.getSessionValue());
        HttpEntity request = new HttpEntity<>(headers);
        return restTemplate.exchange(GET_ALL_PROJECTS, HttpMethod.GET, request, ArrayList.class);
    }
}
