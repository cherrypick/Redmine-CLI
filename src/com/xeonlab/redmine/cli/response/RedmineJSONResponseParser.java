package com.xeonlab.redmine.cli.response;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Konstantin Simon Maria Moellers
 * @version 2015-01-23
 */
public class RedmineJSONResponseParser {

    public RedmineJSONResponseParser() {
    }

    public Response parse(JSONObject input) {
        Response response = new Response();

        if (input.has("offset")) {
            response.setOffset(input.getInt("offset"));
        }

        if (input.has("total_count")) {
            response.setTotalCount(input.getInt("total_count"));
        }

        if (input.has("limit")) {
            response.setLimit(input.getInt("limit"));
        }

        if (input.has("issues")) {
            JSONArray issueArray = input.getJSONArray("issues");
            ArrayList<Issue> issues = new ArrayList<>();

            for (int i = 0; i < issueArray.length(); ++i) {
                JSONObject issueJSON = issueArray.getJSONObject(i);

                Issue issue = new Issue();
                issue.setId(issueJSON.getInt("id"));
                issue.setSubject(issueJSON.getString("subject"));
                issue.setPriority(new EnumeratedValue(issueJSON.getJSONObject("priority")));
                issue.setAssignedTo(new EnumeratedValue(issueJSON.getJSONObject("assigned_to")));
                issue.setProject(new EnumeratedValue(issueJSON.getJSONObject("project")));
                issue.setTracker(new EnumeratedValue(issueJSON.getJSONObject("tracker")));
                issue.setCategory(new EnumeratedValue(issueJSON.getJSONObject("category")));
                issue.setAuthor(new EnumeratedValue(issueJSON.getJSONObject("author")));
                issue.setStatus(new EnumeratedValue(issueJSON.getJSONObject("status")));
                if (issueJSON.has("due_date")) {
                    issue.setDueDate(issueJSON.getDate("due_date"));
                }
                issue.setStartDate(issueJSON.getDate("start_date"));
                issue.setCreatedOn(issueJSON.getDate("created_on"));
                issue.setUpdatedOn(issueJSON.getDate("updated_on"));
                if (issueJSON.has("parent")) {
                    issue.setParent(new EnumeratedValue(issueJSON.getJSONObject("parent")));
                }
                issue.setDoneRatio(issueJSON.getInt("done_ratio"));
                issue.setEstimatedHours(issueJSON.getDouble("estimated_hours"));

                issues.add(issue);
            }

            response.setIssues(issues);
        }

        return response;
    }
}
