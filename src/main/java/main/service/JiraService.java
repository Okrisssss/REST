package main.service;

import main.dto.jira.CurrentUser;
import org.springframework.http.ResponseEntity;

public interface JiraService {

    void getSession();

    ResponseEntity<CurrentUser> getCurrentUser();
}
