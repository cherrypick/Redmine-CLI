package com.xeonlab.redmine.cli.options;

import com.xeonlab.redmine.cli.request.Request;

/**
 * @author Konstantin Simon Maria Moellers
 * @version 2015-01-22
 */
final class MeOption extends RedmineOption {
    MeOption() throws IllegalArgumentException {
        super(null, "me", false, "Retrieves only self-assigned issues.");
    }

    @Override
    public void applyTo(Request request) {
        request.assignToMe();
    }
}
