package com.xeonlab.redmine.cli.options;

import com.xeonlab.redmine.cli.request.Request;

/**
 * @author Konstantin Simon Maria Moellers
 * @version 2015-01-22
 */
final class ApiKeyOption extends RedmineOption {
    ApiKeyOption() throws IllegalArgumentException {
        super("k", "api-key", true, "API key to connect with redmine.");
        setRequired(true);
        setType(String.class);
        setArgName("api-key");
    }

    @Override
    public void applyTo(Request request) {
        request.setApiKey(getValue());
    }
}
