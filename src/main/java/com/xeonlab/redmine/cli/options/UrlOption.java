package com.xeonlab.redmine.cli.options;

import com.xeonlab.redmine.cli.request.Request;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Konstantin Simon Maria Moellers
 * @version 2015-01-22
 */
final class UrlOption extends RedmineOption {
    UrlOption() throws IllegalArgumentException {
        super("u", "url", true, "URL to redmine.");
        setRequired(true);
        setType(URL.class);
        setArgName("url");
    }

    @Override
    public void applyTo(Request request) {
        try {
            request.setUrl(new URL(getValue()));
        } catch (MalformedURLException e) {
            System.err.println("Could not parse URL.");
            System.exit(2);
        }
    }
}
