package com.xeonlab.redmine.cli.options;

import com.xeonlab.redmine.cli.request.Request;

/**
 * @author Konstantin Simon Maria Moellers
 * @version 2015-01-22
 */
final class AssignedToOption extends RedmineOption {
    AssignedToOption() throws IllegalArgumentException {
        super("a", "assigned-to", true, "Assignee of issues to filter.");
        setType(Integer.class);
        setArgName("assignee");
    }

    @Override
    public void applyTo(Request request) {
        request.setAssignedTo(Integer.parseInt(getValue()));
    }
}
