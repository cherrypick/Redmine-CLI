package com.xeonlab.redmine.cli.options;

import com.xeonlab.redmine.cli.request.Request;

/**
 * @author Konstantin Simon Maria Moellers
 * @version 2015-01-22
 */
final class ProjectOption extends RedmineOption {
    ProjectOption() throws IllegalArgumentException {
        super("p", "project", true, "Project to load issues from.");
        setType(String.class);
        setArgName("project");
    }

    @Override
    public void applyTo(Request request) {
        request.setProject(getValue());
    }
}
