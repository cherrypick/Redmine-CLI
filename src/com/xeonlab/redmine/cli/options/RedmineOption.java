package com.xeonlab.redmine.cli.options;

import com.xeonlab.redmine.cli.request.Request;
import org.apache.commons.cli.Option;

/**
 * @author Konstantin Simon Maria Moellers
 * @version 2015-01-22
 */
abstract public class RedmineOption extends Option {
    public RedmineOption(String opt, String description) throws IllegalArgumentException {
        super(opt, description);
    }

    public RedmineOption(String opt, boolean hasArg, String description) throws IllegalArgumentException {
        super(opt, hasArg, description);
    }

    public RedmineOption(String opt, String longOpt, boolean hasArg, String description) throws IllegalArgumentException {
        super(opt, longOpt, hasArg, description);
    }

    /**
     * Applies information to a request.
     *
     * @param request request to manipulate
     */
    abstract public void applyTo(Request request);
}
