package com.xeonlab.redmine.cli.options;

import com.xeonlab.redmine.cli.request.Request;

/**
 * @author Konstantin Simon Maria Moellers
 * @version 2015-01-22
 */
final class StatusOption extends RedmineOption {
    StatusOption() throws IllegalArgumentException {
        super("s", "status", true, "Status ID to filter issues.");
        setType(Integer.class);
        setArgName("status-id");
    }

    @Override
    public void applyTo(Request request) {
        request.setStatus(Integer.parseInt(getValue()));
    }
}
