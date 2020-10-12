package main.util;

import main.dto.issue.Issue;

public class CheckIfObjectNullOrEmpty {


    public static boolean checkIfIssueFieldsIsNullOrEmpty(Issue issue){
        return issue.getFields().getAssignee() != null && issue.getFields().getAssignee().getName().length() != 0 &&
                issue.getFields().getComponents() != null && !issue.getFields().getComponents().isEmpty() &&
                issue.getFields().getDescription() != null && issue.getFields().getDescription().length() != 0 &&
                issue.getFields().getIssuetype() != null && issue.getFields().getIssuetype().getId().length() != 0 &&
                issue.getFields().getLabels() != null && !issue.getFields().getLabels().isEmpty() &&
                issue.getFields().getPriority() != null && issue.getFields().getPriority().getId().length() != 0 &&
                issue.getFields().getProject() != null && issue.getFields().getProject().getId().length() != 0 &&
                issue.getFields().getReporter() != null && issue.getFields().getReporter().getName().length() != 0 &&
                issue.getFields().getSummary() != null && issue.getFields().getSummary().length() != 0;
    }
}
