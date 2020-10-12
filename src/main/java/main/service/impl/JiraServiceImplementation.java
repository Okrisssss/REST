package main.service.impl;

import main.dto.jira.CurrentUser;
import main.dto.jira.SessionResponse;
import main.dto.jira.SessionValue;
import main.exception.EmptyFieldException;
import main.service.JiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static main.util.PageUri.CREATE_SESSION_URL;
import static main.util.PageUri.GET_CURRENT_USER;

@Service
public class JiraServiceImplementation implements JiraService {

    @Autowired
    RestTemplate restTemplate;

    SessionValue sessionValue = new SessionValue();

    @Value("${jira.username}")
    private String username;

    @Value("${jira.password}")
    private String password;


//    jira:
//      username: piachimov
//      password: password


    @Override
    public void getSession() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, String> body = new HashMap<>();
        body.put("username", username);
        body.put("password", password);
        if (body.isEmpty()){
            try {
                throw new EmptyFieldException("Please add your JIRA credentials to application properties");
            } catch (EmptyFieldException e) {
                e.printStackTrace();
            }
        }
        HttpEntity request = new HttpEntity<>(body, headers);
        sessionValue.setSessionValue( restTemplate.postForEntity(CREATE_SESSION_URL, request, SessionResponse.class).getBody().getSession().getValue());
    }

    @Override
    public ResponseEntity<CurrentUser> getCurrentUser() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("cookie", "JSESSIONID=" + sessionValue.getSessionValue());
        HttpEntity request = new HttpEntity<>(headers);
        return restTemplate.exchange(GET_CURRENT_USER, HttpMethod.GET, request, CurrentUser.class);
    }
}
