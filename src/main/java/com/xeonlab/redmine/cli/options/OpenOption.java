package com.xeonlab.redmine.cli.options;

import com.xeonlab.redmine.cli.request.Request;

/**
 * @author Konstantin Simon Maria Moellers
 * @version 2015-01-22
 */
final class OpenOption extends RedmineOption {
    OpenOption() throws IllegalArgumentException {
        super(null, "open", false, "Only open issues.");
    }

    @Override
    public void applyTo(Request request) {
        request.setStatusOpen();
    }
}
