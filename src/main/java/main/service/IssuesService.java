package main.service;

import main.dto.issue.Issue;
import org.springframework.http.ResponseEntity;

public interface IssuesService {

   Object createIssue(Issue issue);

   String deleteIssueById(String id);

   ResponseEntity<String> getIssuesAssignedToUser(String name);
}
