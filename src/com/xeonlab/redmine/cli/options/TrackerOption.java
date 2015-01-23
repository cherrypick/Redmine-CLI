package com.xeonlab.redmine.cli.options;

import com.xeonlab.redmine.cli.request.Request;

/**
 * @author Konstantin Simon Maria Moellers
 * @version 2015-01-22
 */
final class TrackerOption extends RedmineOption {
    TrackerOption() throws IllegalArgumentException {
        super("t", "tracker", true, "Tracker ID to filter issues.");
        setType(Integer.class);
        setArgName("tracker-id");
    }

    @Override
    public void applyTo(Request request) {
        request.setTracker(Integer.parseInt(getValue()));
    }
}
