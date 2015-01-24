package com.xeonlab.redmine.cli.request;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Konstantin Simon Maria Moellers
 * @version 2015-01-22
 */
public class RedmineUrlBuilder {
    public URL parseRequest(Request request) {
        String result = request.getUrl().toString() + "/issues.json?";

        Map<String, String> queryParams = new HashMap<String, String>();
        queryParams.put("key", request.getApiKey());

        if (request.getProject() != null) {
            queryParams.put("project_id", request.getProject());
        }

        if (request.getTracker() != Request.UNSET) {
            queryParams.put("tracker_id", String.valueOf(request.getTracker()));
        }

        if (request.getStatus() != Request.UNSET) {
            if (request.isStatusOpen()) {
                queryParams.put("status_id", "open");
            } else if (request.isStatusClosed()) {
                queryParams.put("status_id", "closed");
            } else {
                queryParams.put("status_id", String.valueOf(request.getStatus()));
            }
        } else {
            queryParams.put("status_id", "*");
        }

        if (request.getAssignedTo() != Request.UNSET) {
            if (request.getAssignedTo() == Request.ME) {
                queryParams.put("assigned_to_id", "me");
            } else {
                queryParams.put("assigned_to_id", String.valueOf(request.getAssignedTo()));
            }
        }

        try {
            ArrayList<String> queryParts = new ArrayList<String>(queryParams.size());
            for (String queryParam : queryParams.keySet()) {
                queryParts.add(queryParam + "=" + URLEncoder.encode(queryParams.get(queryParam), "UTF-8"));
            }
            String query = String.join("&", queryParts);

            return new URL(result + query);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.exit(3);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.exit(4);
        }

        return null;
    }
}
