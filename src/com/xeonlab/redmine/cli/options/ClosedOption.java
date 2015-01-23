package com.xeonlab.redmine.cli.options;

import com.xeonlab.redmine.cli.request.Request;

/**
 * @author Konstantin Simon Maria Moellers
 * @version 2015-01-22
 */
final class ClosedOption extends RedmineOption {
    ClosedOption() throws IllegalArgumentException {
        super(null, "closed", false, "Only closed issues.");
    }

    @Override
    public void applyTo(Request request) {
        request.setStatusClosed();
    }
}
