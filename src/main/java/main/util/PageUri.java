package main.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PageUri {

    public static final String CREATE_SESSION_URL = "https://uatjira.endava.com/rest/auth/1/session";
    public static final String GET_CURRENT_USER = "https://uatjira.endava.com/rest/auth/1/session";
    public static final String GET_ALL_PROJECTS = "https://uatjira.endava.com/rest/api/2/project";
    public static final String CREATE_ISSUE = "https://uatjira.endava.com/rest/api/2/issue";
    public static final String DELETE_ISSUE = "https://uatjira.endava.com/rest/api/2/issue/";
    public static final String GET_ISSUE_BY_ID = "https://uatjira.endava.com/rest/api/2/issue/";


    public static final String CREATE_SESSION = "/createNewSession";
    public static final String AUTH = "/auth";
    public static final String CURRENT_USER = "/currentUser";
    public static final String PROJECT = "/project";
    public static final String ISSUE = "/issue";
    public static final String CREATE = "/create";
    public static final String DELETE = "/delete/{id}";
    public static final String ASSIGNED_TO_USER = "/getTaskAssignedToUser/{username}";
    public static final String ALL = "/all";

}