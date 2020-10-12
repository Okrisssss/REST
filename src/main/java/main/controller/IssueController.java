package main.controller;


import lombok.RequiredArgsConstructor;
import main.dto.issue.Issue;
import main.service.IssuesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static main.util.PageUri.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ISSUE)
public class IssueController {

    private final IssuesService issuesService;

    @PostMapping(CREATE)
    public Object createIssue(@RequestBody Issue issue){
        return issuesService.createIssue(issue);
    }

    @DeleteMapping(DELETE)
    public String deleteIssueById(@PathVariable String id){
        return issuesService.deleteIssueById(id);
    }

    @GetMapping(ASSIGNED_TO_USER)
    public ResponseEntity<String> getIssuesAssignedToUser(@PathVariable String username){
        return issuesService.getIssuesAssignedToUser(username);
    }
}
