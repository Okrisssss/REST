package main.service.impl;

import main.dto.issue.CreateIssueResponse;
import main.dto.issue.Issue;
import main.dto.jira.SessionValue;
import main.exception.EmptyFieldException;
import main.service.IssuesService;
import main.util.CheckIfObjectNullOrEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static main.util.PageUri.*;


@Service
public class IssueServiceImplementation implements IssuesService {

    @Autowired
    JiraServiceImplementation jiraServiceImplementation;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Object createIssue(Issue issue) {
        jiraServiceImplementation.getSession();
        SessionValue sessionValue = jiraServiceImplementation.sessionValue;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("cookie", "JSESSIONID=" + sessionValue.getSessionValue());
        if (CheckIfObjectNullOrEmpty.checkIfIssueFieldsIsNullOrEmpty(issue)) {
            HttpEntity request = new HttpEntity(issue, headers);
            return restTemplate.exchange(CREATE_ISSUE, HttpMethod.POST, request, CreateIssueResponse.class);
        } else {
            try {
                throw new EmptyFieldException("Please fill all necessary fields");
            } catch (EmptyFieldException e) {
                e.printStackTrace();
                return e.getMessage();
            }
        }
    }

    @Override
    public String deleteIssueById(String id) {
        jiraServiceImplementation.getSession();
        SessionValue sessionValue = jiraServiceImplementation.sessionValue;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("cookie", "JSESSIONID=" + sessionValue.getSessionValue());
        HttpEntity request = new HttpEntity(headers);
        try{
            restTemplate.exchange(DELETE_ISSUE.concat(id), HttpMethod.DELETE, request, String.class);
            return "Issue with id - " + id + " was deleted successfully";
        }catch (Exception e){
            return "No Issue with such ID";
        }
    }

    @Override
    public ResponseEntity<String> getIssuesAssignedToUser(String name) {
        String url = "https://uatjira.endava.com/rest/api/2/search?jql=project=JIS AND assignee="+name;
        jiraServiceImplementation.getSession();
        SessionValue sessionValue = jiraServiceImplementation.sessionValue;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("cookie", "JSESSIONID=" + sessionValue.getSessionValue());
        HttpEntity request = new HttpEntity<>(headers);
        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        return result;
    }
}
