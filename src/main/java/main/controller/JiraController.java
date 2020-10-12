package main.controller;


import lombok.RequiredArgsConstructor;

import main.dto.jira.CurrentUser;
import main.service.impl.JiraServiceImplementation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static main.util.PageUri.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(CREATE_SESSION)
public class JiraController {


    private final JiraServiceImplementation jiraServiceImplementation;


    @PostMapping(AUTH)
    public void createSession() {
        jiraServiceImplementation.getSession();
    }

    @GetMapping(CURRENT_USER)
    public ResponseEntity<CurrentUser> getCurrentUser() {
        return jiraServiceImplementation.getCurrentUser();
    }
}