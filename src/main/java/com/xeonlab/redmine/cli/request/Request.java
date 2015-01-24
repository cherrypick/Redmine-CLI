package com.xeonlab.redmine.cli.request;

import java.net.URL;

/**
 * @author Konstantin Simon Maria Moellers
 * @version 2015-01-22
 */
final public class Request {

    final public static int ME = Integer.MIN_VALUE;
    final public static int OPEN = Integer.MIN_VALUE;
    final public static int CLOSED = Integer.MIN_VALUE + 1;
    final public static int UNSET = Integer.MAX_VALUE;

    private URL url;
    private String apiKey;
    private String project;
    private int assignedTo = UNSET;
    private int issue = UNSET;
    private int status = UNSET;
    private int tracker = UNSET;

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public int getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(int assignedTo) {
        this.assignedTo = assignedTo;
    }

    public void assignToMe() {
        this.assignedTo = ME;
    }

    public int getIssue() {
        return issue;
    }

    public void setIssue(int issue) {
        this.issue = issue;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setStatusOpen() {
        this.setStatus(OPEN);
    }

    public boolean isStatusOpen() {
        return this.getStatus() == OPEN;
    }

    public void setStatusClosed() {
        this.setStatus(CLOSED);
    }

    public boolean isStatusClosed() {
        return this.getStatus() == CLOSED;
    }

    public int getTracker() {
        return tracker;
    }

    public void setTracker(int tracker) {
        this.tracker = tracker;
    }
}
