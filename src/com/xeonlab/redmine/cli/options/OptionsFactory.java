package com.xeonlab.redmine.cli.options;

import org.apache.commons.cli.Options;

/**
 * @author Konstantin Simon Maria Moellers
 * @version 2015-01-22
 */
public class OptionsFactory {
    private OptionsFactory() {
    }

   public static Options createOptions() {
        Options options = new Options();

        options.addOption(new UrlOption());
        options.addOption(new ApiKeyOption());
        options.addOption(new ProjectOption());
        options.addOption(new TrackerOption());
        options.addOption(new StatusOption());
        options.addOption(new AssignedToOption());
        options.addOption(new MeOption());
        options.addOption(new OpenOption());
        options.addOption(new ClosedOption());

        return options;
    }
}
