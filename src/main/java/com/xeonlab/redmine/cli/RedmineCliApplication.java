package com.xeonlab.redmine.cli;

import com.xeonlab.redmine.cli.cli.CliColor;
import com.xeonlab.redmine.cli.options.OptionsFactory;
import com.xeonlab.redmine.cli.options.RedmineOption;
import com.xeonlab.redmine.cli.request.RedmineUrlBuilder;
import com.xeonlab.redmine.cli.request.Request;
import com.xeonlab.redmine.cli.response.RedmineJsonResponseParser;
import com.xeonlab.redmine.cli.response.Response;
import com.xeonlab.redmine.cli.response.ResponseParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class RedmineCliApplication {

    private final CommandLineParser parser;
    private final Options options;

    public RedmineCliApplication() {
        parser = new GnuParser();
        options = OptionsFactory.createOptions();

    }

    public static void main(String[] args) {
        RedmineCliApplication application = new RedmineCliApplication();
        application.initialize(args);

        System.setProperty("tool.name", "Redmine CLI Tool");
        System.setProperty("tool.version", "0.1");
    }

    public void initialize(String[] args) {
        try {
            // Parse options.
            CommandLine line = parser.parse(options, args);

            // Apply all options on a request.
            Request request = new Request();
            for (Option option : line.getOptions()) {
                RedmineOption redmineOption = (RedmineOption) option;
                redmineOption.applyTo(request);
            }

            // Build URL to send request.
            RedmineUrlBuilder urlBuilder = new RedmineUrlBuilder();
            URL requestUrl = urlBuilder.parseRequest(request);

            // Connect to URL.
            System.out.println("Connecting to " + requestUrl.toString() + " ...");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(requestUrl.openStream(), "UTF-8"))) {
                // Parse response.
                ResponseParser responseParser = new RedmineJsonResponseParser();
                Response response = responseParser.parse(reader);

                System.out.println(response);
                response.getIssues().forEach(System.out::println);
            } catch (IOException e) {
                System.err.println("IO error – are you connected to internet?");
                System.exit(5);
            }

        } catch (ParseException e) {
            System.err.println("Could not parse arguments.");
            printHelp();
            System.exit(1);
        }
    }

    private void printHelp() {
        HelpFormatter helpFormatter = new HelpFormatter();
        helpFormatter.setLeftPadding(3);
        helpFormatter.setDescPadding(2);
        helpFormatter.setNewLine("\n");
        helpFormatter.setLongOptPrefix(" --");
        helpFormatter.setOptionComparator((obj1, obj2) -> {
            Option o1 = (Option) obj1;
            Option o2 = (Option) obj2;
            if (o1.isRequired()) {
                return -1;
            }

            if (o2.isRequired()) {
                return 1;
            }

            return 0;
        });
        helpFormatter.setWidth(100);
        String toolDescription = System.getProperty("tool.name") + " " + System.getProperty("tool.version");
        String header = CliColor.FG_YELLOW.color(toolDescription) + "\n" +
                "Redmine command line tool.\n" +
                "Copyright (C) 2015 by Konstantin Möllers.";
        helpFormatter.printHelp("redmine", header, options, "", true);
    }
}
