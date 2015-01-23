package com.xeonlab.redmine.cli.response;

import java.util.List;

/**
 * @author Konstantin Simon Maria Moellers
 * @version 2015-01-23
 */
final public class Response {
    private int offset;
    private int limit;
    private int totalCount;
    private List<Issue> issues;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    @Override
    public String toString() {
        return "Response{offset=" + offset +
                ", limit=" + limit +
                ", totalCount=" + totalCount +
                '}';
    }
}
