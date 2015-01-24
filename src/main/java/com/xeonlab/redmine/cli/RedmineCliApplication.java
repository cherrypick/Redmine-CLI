package com.xeonlab.redmine.cli;

import com.xeonlab.redmine.cli.cli.CliColor;
import com.xeonlab.redmine.cli.options.OptionsFactory;
import com.xeonlab.redmine.cli.options.RedmineOption;
import com.xeonlab.redmine.cli.request.RedmineUrlBuilder;
import com.xeonlab.redmine.cli.request.Request;
import com.xeonlab.redmine.cli.response.Issue;
import com.xeonlab.redmine.cli.response.RedmineJsonResponseParser;
import com.xeonlab.redmine.cli.response.Response;
import com.xeonlab.redmine.cli.response.ResponseParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class RedmineCliApplication {

    public static final String TOOL_NAME = "Redmine CLI Tool";
    public static final String TOOL_VERSION = "0.1";

    private final CommandLineParser parser;
    private final Options options;

    public RedmineCliApplication() {
        parser = new GnuParser();
        options = OptionsFactory.createOptions();

    }

    public static void main(String[] args) {
        RedmineCliApplication application = new RedmineCliApplication();
        application.initialize(args);

        System.setProperty("tool.name", TOOL_NAME);
        System.setProperty("tool.version", TOOL_VERSION);
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
            System.err.println("Connecting to " + requestUrl.toString() + " ...");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(requestUrl.openStream(), "UTF-8"))) {
                // Parse response.
                ResponseParser responseParser = new RedmineJsonResponseParser();
                Response response = responseParser.parse(reader);

                System.err.println(response);
                response.getIssues().forEach(issue -> printIssue(request.getUrl(), issue));
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

    /**
     * Prints an issue.
     *
     * @param url
     * @param issue
     */
    private void printIssue(URL url, Issue issue) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        StringBuilder builder = new StringBuilder();

        builder.append(CliColor.FG_YELLOW.color(issue.getTracker().getName() + " #" + issue.getId() + ": "));
        builder.append(CliColor.FG_WHITE.color(issue.getSubject()));
        builder.append('\n');
        builder.append(CliColor.FG_BLUE.color(CliColor.UNDERLINED.color(issue.getWebPath(url))));
        builder.append('\n');

        builder.append("status:     ");
        String status = issue.getStatus().getName();
        builder.append(CliColor.colorIf(status, status.equals("Closed"), CliColor.FG_LIGHT_RED, CliColor.FG_LIGHT_GREEN));
        builder.append('\n');

        builder.append("author:     ");
        String author = issue.getAuthor().getName();
        builder.append(CliColor.FG_LIGHT_CYAN.color(author));
        builder.append('\n');

        if (issue.getFixedVersion() != null) {
            builder.append("version:    ");
            String version = issue.getFixedVersion().getName();
            builder.append(CliColor.FG_LIGHT_CYAN.color(version));
            builder.append('\n');
        }

        builder.append("created on: ");
        builder.append(CliColor.FG_LIGHT_CYAN.color(dateFormat.format(issue.getCreatedOn())));
        builder.append('\n');

        builder.append("updated on: ");
        builder.append(CliColor.FG_LIGHT_CYAN.color(dateFormat.format(issue.getUpdatedOn())));
        builder.append('\n');

        builder.append(CliColor.FG_PURPLE.color(issue.getDescription()));
        builder.append('\n');

        System.out.println(builder);
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
        String toolDescription = TOOL_NAME + " " + TOOL_VERSION;
        String header = CliColor.FG_YELLOW.color(toolDescription) + "\n" +
                "Redmine command line tool.\n" +
                "Copyright (C) 2015 by Konstantin Möllers.";
        helpFormatter.printHelp("redmine", header, options, "", true);
    }
}
